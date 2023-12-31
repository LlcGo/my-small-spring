package com.lc.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.lc.springframework.beans.BeansException;
import com.lc.springframework.beans.PropertyValue;
import com.lc.springframework.beans.factory.core.io.Resource;
import com.lc.springframework.beans.factory.core.io.ResourceLoader;
import com.lc.springframework.beans.factory.factory.BeanDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: com.lc.springframework.beans.factory.support
 * @ClassName: XmlBeanDefinitionReader
 * @Description: 最终
 */

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    //传递给父类进行实现
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    //传递给父类进行实现
    public XmlBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry registry) {
        super(resourceLoader, registry);
    }


    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
             try {
                 try(InputStream inputStream = resource.getInputStream()){
                    doLoadBeanDefinitions(inputStream);
                 }
             }catch (IOException | ClassNotFoundException e) {
                 throw new BeansException("IOException parsing XML document from " + resource, e);
             }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
         for (Resource resource:resources){
             loadBeanDefinitions(resource);
         }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) continue;
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            String beanScope = bean.getAttribute("scope");
            // 获取 Class，方便获取类中的名称
            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }
            // 读取属性并填充
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                // 解析标签：property
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValues(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 BeanDefinition
            getRegistry().registerBean(beanName, beanDefinition);
        }
    }
}
