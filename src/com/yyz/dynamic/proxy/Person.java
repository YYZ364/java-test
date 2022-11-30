package com.yyz.dynamic.proxy;

public class Person implements Subject{
    @Override
    public void shopping(String s) {
        System.out.println("shopping---------------");
        System.out.println(s);
    }

    @Override
    public void eating() {
        System.out.println("eating---------------");
    }
}
