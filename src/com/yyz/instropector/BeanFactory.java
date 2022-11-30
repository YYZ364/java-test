package com.yyz.instropector;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;


/**
 * 通过内省的API来装配一个Bean对象，Bean对象的值是通过配置文件中来获取
 * 目的是提高可维护性
 */
public class BeanFactory {
    private static Properties prop = new Properties();
    //使用静态代码块读取配置文件
    static {
        InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/yyz/instropector/config.properties");
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个bean(得到一个类对象)
     * @param name
     * @return
     */
    public static Object getBean(String name){
        Object bean = null;
        String beanName = prop.getProperty(name);
        System.out.println(beanName);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();
            //通过类信息获取java类的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i <propertyDescriptors.length ; i++) {
                String propertyName = propertyDescriptors[i].getName();
                System.out.println(propertyName);
                if("username".equals(propertyName)){
                    Method writeMethod = propertyDescriptors[i].getWriteMethod();
                    //调用属性set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                    //第一个参数是在哪个对象上进行invoke是这个aclass 要先实例化 第二个参数 是参数 admin
                }else if("password".equals(propertyName)){
                    Method writeMethod = propertyDescriptors[i].getWriteMethod();
                    //调用属性set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
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
