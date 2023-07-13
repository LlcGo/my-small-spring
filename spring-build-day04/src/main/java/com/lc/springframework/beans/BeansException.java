package com.lc.springframework.beans;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframework.beans
 * @ClassName: BeansException
 * @Description:
 */

public class BeansException extends RuntimeException {
    public BeansException(String s) {
        System.out.println(s);
    }
}
