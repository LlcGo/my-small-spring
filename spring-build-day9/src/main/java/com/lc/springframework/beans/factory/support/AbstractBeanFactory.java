package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.config.BeanPostProcessor;
import com.lc.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.lc.springframework.beans.factory.factory.BeanDefinition;
import com.lc.springframework.beans.factory.factory.FactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractBeanFactory
 * @Description: 模板方法  主要实现获取bean  并且缓存
 */

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) {
       return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object ... args){
      return doGetBean(name,args);
    }

    protected <T> T  doGetBean(String name, Object[] args){
        Object sharedInstance = getSingleton(name);
        if(sharedInstance != null){
            return (T)getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T)getObjectForBeanInstance(bean,name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }


    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object [] args);

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
