package com.lc.springframework.beans.factory.factory;

import com.lc.springframework.beans.PropertyValues;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanDefinition
 * @Description:  bean 对象 pojo
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
}
