package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.factory.DisposableBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: DefaultSingletonBeanRegistry
 * @Description: 实现单例模式接口
 */

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private HashMap<String,Object> singletonObjects = new HashMap<String,Object>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<String, DisposableBean>();

    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 受保护的添加属性，只能给子类调用，体现了bean内部自己添加bean
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

}
