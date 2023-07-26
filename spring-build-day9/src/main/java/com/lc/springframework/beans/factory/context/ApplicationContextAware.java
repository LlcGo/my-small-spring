package com.lc.springframework.beans.factory.context;

import com.lc.springframework.beans.factory.factory.Aware;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: com.lc.springframework.beans.factory.context
 * @ClassName: ApplicationContextAware
 * @Description:
 */

public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext);
}
