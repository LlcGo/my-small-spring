package com.lc.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: com.lc.springframework.aop
 * @ClassName: Advisor
 * @Description:
 */

public interface Advisor {

    Advice getAdvice();

}
