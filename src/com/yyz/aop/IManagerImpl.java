package com.yyz.aop;

import java.util.ArrayList;

public class IManagerImpl implements IManager{
    private ArrayList<String> list = new ArrayList<>();
    public void add(String item){
        list.add(item);
        System.out.println(item);
    }
}
