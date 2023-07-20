package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author Lc
 * @Date 2023/7/12
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: SimpleInstantiationStrategy
 * @Description: jdk 实例化
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
            try {
                if(ctor != null) {
                    return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
                }else {
                    return clazz.getDeclaredConstructor().newInstance();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        return null;
    }

}
