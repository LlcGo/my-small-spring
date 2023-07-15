import com.lc.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lc.springframework.beans.factory.support.XmlBeanDefinitionReader;
import org.junit.Test;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: PACKAGE_NAME
 * @ClassName: TestXml
 * @Description:
 */

public class TestXml {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
