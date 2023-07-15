package com.lc.springframework.beans.factory.support;

import com.lc.springframework.beans.factory.core.io.DefaultResourceLoader;
import com.lc.springframework.beans.factory.core.io.ResourceLoader;
import com.lc.springframework.beans.factory.factory.BeanDefinitionReader;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: AbstractBeanDefinitionReader
 * @Description: 抽象接口实现 BeanDefinitionReader的获取
 *               resourceLoader 和 registry 方法
 *
 *               这样在接口 BeanDefinitionReader 的具体实现类中，
 *               就可以把解析后的 XML 文件中的 Bean 信息，
 *               注册到 Spring 容器去了   ----》 XmlBeanDefinitionReader
 */

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private ResourceLoader resourceLoader;

    private BeanDefinitionRegistry registry;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        //如果不传使用默认的加载器
        this(new DefaultResourceLoader(),registry);
    }

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry registry) {
        this.resourceLoader = resourceLoader;
        this.registry = registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}
