package com.yyz.bean;

//import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanTest {

    @Test
    public void test(){
        //从客户端获取到的数据是是这样的
        String name = "小白";
        String age = "18";
        String salary = "20000";

        Emp emp = new Emp();
        System.out.println(emp.getInfo());
    }
}
