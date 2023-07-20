package com.lc.springframework.beans.factory.config;

import com.lc.springframework.beans.factory.HierarchicalBeanFactory;
import com.lc.springframework.beans.factory.support.SingletonBeanRegistry;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}