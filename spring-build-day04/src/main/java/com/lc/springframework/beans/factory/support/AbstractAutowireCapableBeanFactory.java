package com.lc.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.PropertyValue;
import com.lc.springframework.beans.PropertyValues;
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
    public Object createBean(String beanName, BeanDefinition beanDefinition,Object [] args) {
        Object bean = null;
        bean = createBeanInstance(beanDefinition,beanName,args);

        applyPropertyValues(beanName,bean,beanDefinition);
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

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue p : propertyValues.getPropertyValues()){
                String name = p.getName();
                Object value = p.getValue();
                if(value instanceof BeanReference){
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
           throw new BeansException("Error setting property values：" + beanName);
        }
    }

}
