package com.lc.springframework.beans.factory.factory;

import cn.hutool.core.bean.BeanException;

/**
 * @Author Lc
 * @Date 2023/7/20
 * @PackageName: com.lc.springframework.beans.factory
 * @ClassName: BeanFactoryAware
 * @Description: 实现该接口能够感知到 BeanFactory
 */

public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory)throws BeanException;

}
