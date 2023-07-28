package com.test2;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.PropertyValue;
import com.lc.springframework.beans.PropertyValues;
import com.lc.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.lc.springframework.beans.factory.factory.BeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValues(new PropertyValue("company", "改为：字节跳动"));
    }

}