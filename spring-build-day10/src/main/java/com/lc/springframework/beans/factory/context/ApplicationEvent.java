package com.lc.springframework.beans.factory.context;

import java.util.EventObject;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: com.lc.springframework.beans.factory.context
 * @ClassName: ApplicationEvent
 * @Description: 继承EventObject 任何监听器的类是继承这个抽象类
 */

public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
