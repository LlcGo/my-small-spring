package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: BeanFactoryAware
 * @Description:
 */

public interface BeanFactoryAware extends Aware {
      void setBeanFactory(BeanFactory beanFactory);
}
