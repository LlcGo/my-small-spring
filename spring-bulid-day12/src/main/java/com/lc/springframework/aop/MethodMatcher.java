package com.lc.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author Lc
 * @Date 2023/7/27
 * @PackageName: com.lc.springframework.aop
 * @ClassName: MethodMacher
 * @Description:
 */

public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
