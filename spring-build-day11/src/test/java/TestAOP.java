import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Lc
 * @Date 2023/7/27
 * @PackageName: PACKAGE_NAME
 * @ClassName: TestAOP
 * @Description:
 */

public class TestAOP {

    @Test
    public void test1(){
        Object targetObj = new UserService();
//        (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        })
    }

}
