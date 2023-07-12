package com.lc.springframework.beans.factory.support;

import java.util.HashMap;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: DefaultSingletonBeanRegistry
 * @Description: 实现单例模式接口
 */

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private HashMap<String,Object> singletonObjects = new HashMap<String,Object>();


    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 受保护的添加属性，只能给子类调用，体现了bean内部自己添加bean
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
