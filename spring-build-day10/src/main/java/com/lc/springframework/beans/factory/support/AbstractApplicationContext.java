package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.lc.springframework.beans.factory.config.BeanPostProcessor;
import com.lc.springframework.beans.factory.context.ApplicationEvent;
import com.lc.springframework.beans.factory.context.ApplicationListener;
import com.lc.springframework.beans.factory.context.ConfigurableApplicationContext;
import com.lc.springframework.beans.factory.context.event.ApplicationEventMulticaster;
import com.lc.springframework.beans.factory.context.event.ContextClosedEvent;
import com.lc.springframework.beans.factory.context.event.ContextRefreshedEvent;
import com.lc.springframework.beans.factory.context.event.SimpleApplicationEventMulticaster;
import com.lc.springframework.beans.factory.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractApplicationContext
 * @Description: 可以处理 spring.xml 配置的资源加载
 */

public abstract  class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    /**
     *  实例化之前的方法！！！！！！！！！！！
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {
        //创建beanFactory,并加载BeanDefinition
        refreshBeanFactory();
        //获取beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        //BeanPostProcessor 需要提前于其他Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 6. 初始化事件发布者
        initApplicationEventMulticaster();

        // 7. 注册事件监听器
        registerListeners();

        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }


    //初始化发送的消息
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }


    //虚拟机钩子调用了这个colse方法
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    //手动关闭
    @Override
    public void close() {
        // 发布容器关闭事件
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingletons();
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }


}
