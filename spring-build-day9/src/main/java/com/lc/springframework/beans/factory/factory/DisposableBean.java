package com.lc.springframework.beans.factory.factory;

/**
 * @Author Lc
 * @Date 2023/7/17
 * @PackageName: com.lc.springframework.beans.factory.factory
 * @ClassName: DisposableBean
 * @Description: 销毁接口
 */

public interface DisposableBean {
    /**
     * 销毁方法
     * @throws Exception
     */
    void destroy() throws Exception;
}
