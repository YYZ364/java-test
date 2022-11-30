package com.yyz.instropector;

import org.junit.Test;

public class BeanTest {
    @Test
    public void test(){
        Config bean = (Config) BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
