package com.lc.springframwork;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Lc
 * @Date 2023/7/10
 * @PackageName: com.lc.springframwork
 * @ClassName: BeanFactory
 * @Description: Bean 注册 和 生产 的 工厂
 */

public class BeanFactory {

    private Map <String,BeanDefinition> beanMap = new ConcurrentHashMap<String,BeanDefinition>();

    public BeanDefinition getBeanDefinition(String name){
        return beanMap.get(name);
    }

    public void registBean(String name, BeanDefinition beanDefinition){
        beanMap.put(name,beanDefinition);
    }

}
