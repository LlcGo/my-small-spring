package com.lc.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: com.lc.springframework.aop
 * @ClassName: MethodBeforeAdvice
 * @Description:
 */

public interface MethodBeforeAdvice extends  BeforeAdvice {

    void before(Method method,Object[] args,Object target)throws Throwable;

}
