package com.lc.springframework.beans.factory.factory;


import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.core.io.Resource;
import com.lc.springframework.beans.factory.core.io.ResourceLoader;
import com.lc.springframework.beans.factory.support.BeanDefinitionRegistry;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanDefinitionReader
 * @Description: 读取bean的接口
 */

public interface BeanDefinitionReader {

    //获得注册的数据信息
    BeanDefinitionRegistry getRegistry();

    //获得读取的资源的信息
    ResourceLoader getResourceLoader();

    //都是读取类并且初始话的方法
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
