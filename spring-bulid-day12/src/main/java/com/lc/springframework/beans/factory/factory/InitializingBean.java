package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/17
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: InitializingBean
 * @Description:
 */

public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
