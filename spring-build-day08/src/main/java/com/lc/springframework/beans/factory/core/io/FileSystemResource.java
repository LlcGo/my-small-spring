package com.lc.springframework.beans.factory.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.core.io
 * @ClassName: FileSystemResource
 * @Description: 可以根据各种文件和路径来获取 对应的流
 */

public class FileSystemResource implements Resource {
    //文件
    private File file;
    //路径
    private String path;

    /**
     * 根据文件获取路径并且赋值
     * @param file
     */
    public FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }

    /**
     * 根据路径获取文件并且赋值
     * @param path
     */
    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
