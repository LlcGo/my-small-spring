package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: ClassPathXmlApplicationContext
 * @Description: 应用上下文实现类
 */

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    private String [] configLocations;

    public ClassPathXmlApplicationContext(){

    }

    /**
     * 从XML 中加载 BeanDefinition,并刷新上下文
     * @param configLocations
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
