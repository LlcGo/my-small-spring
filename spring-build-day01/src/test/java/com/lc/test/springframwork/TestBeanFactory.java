package com.lc.test.springframwork;

import com.lc.springframwork.BeanDefinition;
import com.lc.springframwork.BeanFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author Lc
 * @Date 2023/7/10
 * @PackageName: com.lc.test.springframwork
 * @ClassName: TestBeanFactory
 * @Description:
 */

public class TestBeanFactory {

   //初始化bean
   BeanDefinition beanDefinition = new BeanDefinition(new UserService());

   //初始化bean工厂
   private BeanFactory beanFactory = new BeanFactory();


   @Test
   public void test(){
      //注册bean进工厂
      beanFactory.registBean("userService",beanDefinition);

      //或者这个bean
      BeanDefinition beanDefinition  = beanFactory.getBeanDefinition("userService");

      //获得这个bean的实例
      UserService userService = (UserService)beanDefinition.getBean();

      //测试方法
      Assert.assertTrue("登录成功".equals(userService.userLogin()));

   }
}
