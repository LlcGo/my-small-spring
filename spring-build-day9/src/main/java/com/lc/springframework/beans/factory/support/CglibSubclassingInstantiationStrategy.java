package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author Lc
 * @Date 2023/7/12
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: CglibSubclassingInstantiationStrategy
 * @Description: Cglib实现 第二步实例化 本来应该有实例化前和实例化后的方法，并没有实现
 */

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(null  == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
