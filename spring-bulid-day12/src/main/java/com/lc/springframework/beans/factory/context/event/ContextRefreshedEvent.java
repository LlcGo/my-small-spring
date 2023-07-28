package com.lc.springframework.beans.factory.context.event;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: com.lc.springframework.beans.factory.context.event
 * @ClassName: ContextRefreshedEvent
 * @Description: 监听上下文刷新
 */

public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
