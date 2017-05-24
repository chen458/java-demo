package com.csh.demo.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 *
 * @author chenshenghong
 * @version 1.0
 * @created 2017/5/24
 * @time 下午11:38
 */
public class IntrospectorDemo {
    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();

        //PropertyDescriptor 内省类测试
        propertyDescriptorTest(userInfo, "userName", "小明童鞋");
        System.out.println("getUserName value" + userInfo.getUserName());

        //Introspector 测试
        introspectorTest(userInfo, "userId", 123456L);
        System.out.println("getUserId value" + userInfo.getUserId());
    }

    /**
     * PropertyDescriptor 内省类使用测试
     * 设置属性值和获取属性值
     * @param info
     * @param propertyName
     * @throws Exception
     */
    private static void propertyDescriptorTest(UserInfo info, String propertyName, Object value) throws Exception {
        //设置属性值
        PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, UserInfo.class);
        //获得属性的Class对象
        Class<?> propertyType = descriptor.getPropertyType();
        //获取用于写入属性值的方法。
        Method writeMethod = descriptor.getWriteMethod();
        //类型不匹配就返回
        if (! value.getClass().equals(propertyType)) {
            System.out.println("PropertyDescriptor 类型不匹配 : " + propertyType.getName() + "===" + value.getClass().getName());
            return;
        }

        System.out.println("PropertyDescriptor set " + propertyName + " value = " + value);
        writeMethod.invoke(info, value);

        //获取属性值
        Method readMethod = descriptor.getReadMethod();
        Object propertyObject = readMethod.invoke(info);

        System.out.println("PropertyDescriptor get " + propertyName + " value = " + propertyObject);
    }

    /**
     * 内省 Introspector 类 demo
     * @param info
     * @param propertyName
     */
    public static void introspectorTest(UserInfo info, String propertyName, Object value) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(info.getClass());
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        if (null == descriptors || descriptors.length < 1)
            return;
        for (PropertyDescriptor descriptor : descriptors) {
            if (descriptor.getName().equals(propertyName)) {

                if ( ! descriptor.getPropertyType().equals(value.getClass())){
                    System.out.println("Introspector 类型不匹配 : " + descriptor.getPropertyType().getName() + "===" + value.getClass().getName());
                    return;
                }

                Method writeMethod = descriptor.getWriteMethod();
                writeMethod.invoke(info, value);
                System.out.println("PropertyDescriptor set " + propertyName + " value = " + value);

                Method readMethod = descriptor.getReadMethod();
                Object propertyValue = readMethod.invoke(info);
                System.out.println("PropertyDescriptor get " + propertyName + " value = " + propertyValue);
            }
        }
    }

}
