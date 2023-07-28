package com.lc.springframework.beans.factory.context.event;

import com.lc.springframework.beans.factory.context.ApplicationContext;
import com.lc.springframework.beans.factory.context.ApplicationEvent;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: com.lc.springframework.beans.factory.context.event
 * @ClassName: ApplicationContextEvent
 * @Description:
 */

public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }


}
