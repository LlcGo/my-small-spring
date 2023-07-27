package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author Lc
 * @Date 2023/7/12
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: InstantiationStrategy
 * @Description: 实例化策略接口
 */

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args);

}
