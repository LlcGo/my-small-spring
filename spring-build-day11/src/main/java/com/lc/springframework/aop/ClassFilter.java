package com.lc.springframework.aop;

/**
 * @Author Lc
 * @Date 2023/7/27
 * @PackageName: com.lc.springframework.aop
 * @ClassName: ClassFilter
 * @Description:
 */

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
