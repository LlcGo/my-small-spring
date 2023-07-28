package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/20
 * @PackageName: com.lc.springframework.beans.factory.utils
 * @ClassName: BeanClassLoaderAware
 * @Description: 实现次接口能够感知到ClassLoader
 */

public interface BeanClassLoaderAware {

    void setBeanClassLoader(ClassLoader classLoader);

}
