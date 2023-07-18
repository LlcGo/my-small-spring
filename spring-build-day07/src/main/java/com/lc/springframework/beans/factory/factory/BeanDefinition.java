package com.lc.springframework.beans.factory.factory;

import com.lc.springframework.beans.PropertyValues;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanDefinition
 * @Description:  bean 对象 pojo     第一步  BeanDefinition
 */

public class BeanDefinition {
    /**
     * 只有class 才能 再容器内部创建 newInstance
     */
    private Class beanClass;

    /**
     * 属性值 可能有多个
     */
    private PropertyValues propertyValues;

    /**
     * 初始化方法
     */
    private String initMethodName;

    /**
     * 销毁方法
     */
    private String destroyMethodName;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }



    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
