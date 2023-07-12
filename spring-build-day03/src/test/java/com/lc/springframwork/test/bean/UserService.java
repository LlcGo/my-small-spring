package com.lc.springframwork.test.bean;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: com.lc.springframwork.test.bean
 * @ClassName: UserService
 * @Description:
 */

public class UserService {
    String name = "lc";

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("获取用户信息" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
