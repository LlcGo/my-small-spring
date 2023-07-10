package com.lc.springframwork;

/**
 * @Author Lc
 * @Date 2023/7/10
 * @PackageName: com.lc.springframwork
 * @ClassName: BeanDefinition
 * @Description: 初始化 Bean 容器
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
