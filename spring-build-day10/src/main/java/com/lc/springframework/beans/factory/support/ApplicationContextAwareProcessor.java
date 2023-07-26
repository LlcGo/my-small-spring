package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.config.BeanPostProcessor;
import com.lc.springframework.beans.factory.context.ApplicationContext;
import com.lc.springframework.beans.factory.context.ApplicationContextAware;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: ApplicationContextAwareProcessor
 * @Description:
 */

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ApplicationContextAware){
            ((ApplicationContextAware)bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
