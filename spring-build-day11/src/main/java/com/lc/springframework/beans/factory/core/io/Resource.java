package com.lc.springframework.beans.factory.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: Resource
 * @Description: 资源接口
 */

public interface Resource {

    /**
     * 统一获得资源接口
     * @return
     */
    InputStream getInputStream() throws IOException;

}
