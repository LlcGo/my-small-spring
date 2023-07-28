package com.lc.springframework.aop.framework;

import com.lc.springframework.aop.AdvisedSupport;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: com.lc.springframework.aop.framework
 * @ClassName: ProxyFactory
 * @Description: 代理工厂
 */

public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JdkDynamicAopProxy(advisedSupport);
    }
}
