package com.lc.springframework.beans.factory.context;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.context
 * @ClassName: ConfigurableApplicationContext
 * @Description: 定义刷新容器的功能
 */

public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     */
    void refresh()throws BeansException;
}
