package com.lc.springframework.beans.factory.support;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: SingletonBeanRegistry
 * @Description: 提供单例注册 接口 定义
 */

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);

}
