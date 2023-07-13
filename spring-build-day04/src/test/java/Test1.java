import com.lc.springframework.beans.PropertyValue;
import com.lc.springframework.beans.PropertyValues;
import com.lc.springframework.beans.factory.factory.BeanDefinition;
import com.lc.springframework.beans.factory.support.BeanReference;
import com.lc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author Lc
 * @Date 2023/7/13
 * @PackageName: PACKAGE_NAME
 * @ClassName: Test
 * @Description:
 */

public class Test1{
    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBean("userDao", new BeanDefinition(UserDao.class));

//        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValues(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValues(new PropertyValue("userDao",new BeanReference("userDao")));
//
//        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBean("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
