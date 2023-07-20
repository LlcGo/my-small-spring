package com.lc.springframework.beans.factory.context;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.Aware;

/**
 * @Author Lc
 * @Date 2023/7/20
 * @PackageName: com.lc.springframework.beans.factory.context
 * @ClassName: ApplicationContextAware
 * @Description: 实现此接口 能感知所属的ApplicationContext
 */

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
