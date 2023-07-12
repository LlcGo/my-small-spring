package com.lc.springframwork.test;

import com.lc.springframework.beans.factory.factory.BeanDefinition;
import com.lc.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lc.springframwork.test.bean.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframwork.test
 * @ClassName: ApiTest
 * @Description:
 */

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBean("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }
}
