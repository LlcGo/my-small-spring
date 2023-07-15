import com.lc.springframework.beans.factory.support.ClassPathXmlApplicationContext;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: PACKAGE_NAME
 * @ClassName: Test
 * @Description:
 */

public class Test {

    @org.junit.Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
