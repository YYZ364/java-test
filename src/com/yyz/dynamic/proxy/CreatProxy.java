package com.yyz.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CreatProxy implements InvocationHandler {
    private Object target;
    public Object create(Object target){
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(1);
        System.out.println(2);
        System.out.println(Arrays.toString(args));
        method.invoke(target,args);
        System.out.println(3);
        return null;
    }
}
