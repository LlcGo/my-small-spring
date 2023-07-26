package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.lc.springframework.beans.factory.config.BeanPostProcessor;
import com.lc.springframework.beans.factory.context.ConfigurableApplicationContext;
import com.lc.springframework.beans.factory.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractApplicationContext
 * @Description: 可以处理 spring.xml 配置的资源加载
 */

public abstract  class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
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

        //添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        //BeanPostProcessor 需要提前于其他Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    //虚拟机钩子调用了这个colse方法
    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    //手动关闭
    @Override
    public void close() {
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
