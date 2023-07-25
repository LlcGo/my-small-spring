package com.lc.springframework.beans.factory.factory;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: AutowireCapableBeanFactory
 * @Description:
 */

public interface AutowireCapableBeanFactory {
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
