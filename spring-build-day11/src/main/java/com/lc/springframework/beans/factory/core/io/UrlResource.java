package com.lc.springframework.beans.factory.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: UrlResource
 * @Description: 通过 HTTP 的方式读取云服务的文件
 */

public class UrlResource implements Resource {
    private URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"url不能为null");
        this.url = url;
    }

    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try {
            return connection.getInputStream();
        }catch (IOException ex){
          if(connection instanceof HttpURLConnection){
              ((HttpURLConnection) connection).disconnect();
          }
            throw ex;
        }
    }
}
