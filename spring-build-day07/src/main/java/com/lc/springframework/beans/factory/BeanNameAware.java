package com.lc.springframework.beans.factory;

/**
 * @Author Lc
 * @Date 2023/7/20
 * @PackageName: com.lc.springframework.beans.factory
 * @ClassName: BeanNameAware
 * @Description: 实现接口，能感知所属的BeanName
 */

public interface BeanNameAware {

    void setBeanName(String name);

}
