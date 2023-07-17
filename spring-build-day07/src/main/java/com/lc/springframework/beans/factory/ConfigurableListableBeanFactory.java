package com.lc.springframework.beans.factory;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.config.BeanPostProcessor;
import com.lc.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.lc.springframework.beans.factory.factory.AutowireCapableBeanFactory;
import com.lc.springframework.beans.factory.factory.BeanDefinition;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}