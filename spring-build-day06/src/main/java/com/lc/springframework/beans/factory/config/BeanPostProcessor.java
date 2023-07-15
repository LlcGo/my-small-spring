package com.lc.springframework.beans.factory.config;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.config
 * @ClassName: BeanPostProcessor
 * @Description: 新增实例化bean前后的扩展点
 */

public interface BeanPostProcessor {
    /**
     * 初始化前执行
     */
     Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException;
    /**
     * 初始化之后执行
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
