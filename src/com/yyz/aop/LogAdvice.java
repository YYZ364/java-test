package com.yyz.aop;

public class LogAdvice implements Advice{
    @Override
    public void afterAdvice() {
        System.out.println("startTime: "+System.currentTimeMillis());
    }

    @Override
    public void beforeAdvice() {
        System.out.println("endTime: "+System.currentTimeMillis());
    }
}
