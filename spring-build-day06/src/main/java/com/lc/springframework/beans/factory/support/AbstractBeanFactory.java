package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;
import com.lc.springframework.beans.factory.factory.BeanFactory;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractBeanFactory
 * @Description: 模板方法  主要实现获取bean  并且缓存
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
       return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object ... args){
      return doGetBean(name,args);
    }

    protected <T> T  doGetBean(String name, Object[] args){
        Object bean = getSingleton(name);
        if(bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    };


    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition,Object [] args);

}
