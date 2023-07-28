package com.lc.springframework.beans.factory.context.event;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: com.lc.springframework.beans.factory.context.event
 * @ClassName: ContextClosedEvent
 * @Description: 监听上下文关闭
 */

public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
