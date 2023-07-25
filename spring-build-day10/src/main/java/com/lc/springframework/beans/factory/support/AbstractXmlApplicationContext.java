package com.lc.springframework.beans.factory.support;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractXmlApplicationContext
 * @Description: 上下文配置中心信息加载
 */

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(this,beanFactory);
        String[] configLocations = getConfigLocations();
        if(null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
