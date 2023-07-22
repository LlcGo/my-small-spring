package com.lc.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;
import com.lc.springframework.beans.factory.utils.ClassUtils;

import java.io.InputStream;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: ClassPathResource
 * @Description: 实现资源解析的构造器
 */

public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader)null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"资源注册器不能为空");
        this.path = path;
        //TODO
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());;
    }

    public InputStream getInputStream() {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            System.out.println("文件流错误");
        }
        return is;
    }
}
