package com.lc.springframework.aop;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: com.lc.springframework.aop
 * @ClassName: PointcutAdvisor
 * @Description:
 */

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
