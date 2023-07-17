package com.lc.springframework.beans.factory.factory;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanFactory
 * @Description: bean 工厂 接口
 */

public interface BeanFactory {

    Object getBean(String name);

    /**
     * 构造有构造器的类
     * @param name
     * @param args
     * @return
     */
    Object getBean(String name, Object... args);

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
