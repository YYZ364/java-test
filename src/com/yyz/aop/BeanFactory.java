package com.yyz.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {
    Properties prop = new Properties();
    public BeanFactory(InputStream in){
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个bean实例
     */
    public Object getBean(String name){
        Object bean = null;
        String beanName = prop.getProperty(name);
        System.out.println(beanName);
        try {
            //实例化 获取ProxyFactoryBean的Classd对象
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();
            //根据配置文件实例化target advice对象
            Object target = Class.forName(prop.getProperty(name+".target")).newInstance();
            Object advice = Class.forName(prop.getProperty(name+".advice")).newInstance();
            //通过内省实现对ProxyFactoryBean的属性赋值
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i <propertyDescriptors.length ; i++) {
                String propertyName = propertyDescriptors[i].getName();
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if("target".equals(propertyName)){
                    //调用属性set方法
                    writeMethod.invoke(bean,target);//把target赋值给bean对象的属性
//                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                    //第一个参数是在哪个对象上进行invoke是这个aclass 要先实例化 第二个参数 是参数 admin
                }else if("advice".equals(propertyName)){
                    //调用属性set方法
                    writeMethod.invoke(bean,advice);
//                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
