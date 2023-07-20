package com.lc.springframework.beans;

/**
 * @Author Lc
 * @Date 2023/7/13
 * @PackageName: com.lc.springframework.beans
 * @ClassName: PropertyValue
 * @Description: 属性pojo
 */

public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
