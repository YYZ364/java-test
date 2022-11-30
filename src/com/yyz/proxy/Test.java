package com.yyz.proxy;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Test {
    public static void main(String[] args) {
        Action userAction = new UserAction();
        ActionProxy proxy = new ActionProxy(userAction);
        proxy.doAction();
    }

    //业务接口
interface Action{
    public void doAction();
}

static class UserAction implements Action{
    @Override
    public void doAction() {
        System.out.println("开始工作。。。。。。。");
        for (int i = 0; i <100 ; i++) {
            System.out.println(i*i);
        }
    }
}

static class ActionProxy implements Action {
    private Action target;//被代理的对象

    public ActionProxy(Action target) {
        this.target = target;
    }

    @Override
    public void doAction() {
        long startTime = System.currentTimeMillis();
        target.doAction();//执行真正的业务
        long endTime = System.currentTimeMillis();
        System.out.println("总共耗时为：" + (endTime - startTime));
    }
}}
