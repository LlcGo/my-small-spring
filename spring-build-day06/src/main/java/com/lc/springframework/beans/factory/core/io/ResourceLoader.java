package com.lc.springframework.beans.factory.core.io;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: ResourceLoader
 * @Description: 获取真正资源的流的接口
 */

public interface ResourceLoader {

    /**
     * 判断是否是本地文件
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取流接口
     * @param location
     * @return
     */
    Resource getResource(String location);

}
