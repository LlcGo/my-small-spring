package com.lc.springframework.beans.factory.context.event;

import com.lc.springframework.beans.factory.context.ApplicationEvent;
import com.lc.springframework.beans.factory.context.ApplicationListener;
import com.lc.springframework.beans.factory.factory.BeanFactory;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    //遍历放入消息
    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}