package com.yyz;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

    @Test
    public void Test1(){

        Dog dog = new Dog("金毛",3,"orange");

        //通过对象的getclass()方法
        Class a = dog.getClass();

        //通过类.class
        Class b = Dog.class;

        //通过class.forname()方法
        try {
            Class c = Class.forName("com.yyz.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test2(){
        Class<Dog> dogClass = Dog.class;
        try {
            //通过Class对象实例化类对象，调用了默认无参的构造方法
            //所以在定义类时一般要提供一个默认无参的构造方法
            Dog dog=  (Dog) dogClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test3(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        //获取一个指定的构造方法
        try {
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            //调用带参数的构造器来实例化对象
            try {
                constructor.newInstance("小白",3,"whit");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test4(){
        Class<Dog> dogClass = Dog.class;
        //获取所有非私有属性
        Field[] fileds = dogClass.getFields();
        System.out.println(fileds.length);

        //获取属性（包括私有属性）
        Field[] declaredFields = dogClass.getDeclaredFields();
        System.out.println(declaredFields.length);

        for (int i = 0; i <declaredFields.length ; i++) {
            int modifiers = declaredFields[i].getModifiers();//修饰符
//            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers)+"----"+declaredFields[i].getName()+"---"+declaredFields[i].getType());
        }
    }
}
