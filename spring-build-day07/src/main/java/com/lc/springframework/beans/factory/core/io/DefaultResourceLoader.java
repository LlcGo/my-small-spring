package com.lc.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: DefaultResourceLoader
 * @Description: 最终获取流的类
 */

public class DefaultResourceLoader implements ResourceLoader {
    public Resource getResource(String location) {
        Assert.notNull(location,"目的文件不能为null");
        //开头是否为classpath：
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            //取classpath：后面的数据
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            //是访问网络的流
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //访问文件的流
                return new FileSystemResource(location);
            }
        }
    }
}
