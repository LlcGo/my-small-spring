package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanClassLoaderAware
 * @Description:
 */

public interface BeanClassLoaderAware extends Aware{
     void setBeanClassLoader(ClassLoader classLoader);
}
