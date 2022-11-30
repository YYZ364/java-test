package com.yyz.dynamic.proxy;

import org.junit.Test;

public class TestDemo {
    @Test
    public void test() throws Throwable {
        Subject person = new Person();
        CreatProxy cp = new CreatProxy();
        Subject proxy = (Subject) cp.create(person);
        proxy.shopping("aaaaaaaaaaaaaa");
    }
    @Test
    public void test1() throws Throwable {
        Subject person = new Person();
        CreatProxy cp = new CreatProxy();
        Subject proxy = (Subject) cp.create(person);
        proxy.eating();
    }
}

