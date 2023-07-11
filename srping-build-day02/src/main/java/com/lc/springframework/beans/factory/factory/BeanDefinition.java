package com.lc.springframework.beans.factory.factory;

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

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
