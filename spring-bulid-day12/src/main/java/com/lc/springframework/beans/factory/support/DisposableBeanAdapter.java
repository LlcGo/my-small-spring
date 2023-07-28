package com.lc.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.factory.factory.BeanDefinition;
import com.lc.springframework.beans.factory.factory.DisposableBean;

import java.lang.reflect.Method;

/**
 * @Author Lc
 * @Date 2023/7/17
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: DisposableBeanAdapter
 * @Description: 适配器模式 将bean组合进来 然后执行方法
 */

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //查看是否实现了接口然后进行销毁的
        if(bean instanceof DisposableBean) {
              ((DisposableBean)bean).destroy();
          }
        //xml配置信息防止二次销毁
        if(StrUtil.isNotBlank(destroyMethodName) &&
                !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))){
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if(destroyMethod == null){
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
