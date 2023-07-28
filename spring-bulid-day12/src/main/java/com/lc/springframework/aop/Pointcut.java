package com.lc.springframework.aop;



/**
 * @Author Lc
 * @Date 2023/7/27
 * @PackageName: com.lc.springframework.aop
 * @ClassName: Pointcut
 * @Description: 切点表达式
 */

public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
