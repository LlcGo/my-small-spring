package com.lc.springframework.beans.factory.config;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: com.lc.springframework.beans.factory.config
 * @ClassName: InstantiationAwareBeanPostProcessor
 * @Description:
 */

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
