package com.lc.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/13
 * @PackageName: com.lc.springframework.beans.factory
 * @ClassName: PropertyValues
 * @Description: 存放多个属性 的 pojo 对类里的属性进行的封装
 */

public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValue[]  getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public void addPropertyValues(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
