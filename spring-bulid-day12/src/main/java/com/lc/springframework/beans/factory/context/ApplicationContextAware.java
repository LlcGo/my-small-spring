package com.lc.springframework.beans.factory.context;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}