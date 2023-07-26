package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanNameAware
 * @Description:
 */

public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
