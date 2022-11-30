package com.yyz.aop;

import org.junit.Test;

import java.io.InputStream;

public class AOPTest {
    @Test
    public void test(){
        //读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/yyz/aop/bean.properties");
        //创建bean的工厂对象-----完成从配置文件中读取内容，完成ProxyFactoryBean对象的创建与装配
        BeanFactory beanFactory = new BeanFactory(in);
        //获取代理对象
        //创建 代理对象
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");
        //获取 代理对象
        IManager proxy = (IManager) proxyFactoryBean.getProxy();
        proxy.add("他是百晓生");
    }
}
