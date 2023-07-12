package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description: 实现了创建bean
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //呼应getBean进行缓存
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName, Object[] args)  {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> [] declaredConstructor = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructor) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition,beanName,constructorToUse,args);
    }


}
