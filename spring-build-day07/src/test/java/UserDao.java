import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<String, String>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10002", "6");
        hashMap.put("10003", "66");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}