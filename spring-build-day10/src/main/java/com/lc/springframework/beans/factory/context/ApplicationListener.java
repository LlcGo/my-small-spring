package com.lc.springframework.beans.factory.context;

import java.util.EventListener;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: com.lc.springframework.beans.factory.context
 * @ClassName: ApplicationListener
 * @Description: 实现重写就可以触发
 */

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
  void onApplicationEvent(E event);
}
