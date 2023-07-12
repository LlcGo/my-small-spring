package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: BeanDefinitionRegistry
 * @Description:
 */

public interface BeanDefinitionRegistry {
   void registerBean(String beanName, BeanDefinition beanDefinition);
}
