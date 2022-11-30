package com.yyz.bean;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.*;
import java.util.Properties;

public class propertyDemo {
    public static String username = "";
    public static String password = "";
//读取properties配置文件
    static {
//        readConfig();
    }

    private static void writeConfig(String username,String password){
        Properties p = new Properties();
        p.put("db.username",username);
        p.put("db.password",password);
        try {
//            OutputStream out = new FileOutputStream("comfig.properties");
            OutputStream out = new FileOutputStream("comfig.properties");
            try {
                p.store(out,"config updated");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void readConfig(){
        try {
            Properties p = new Properties();
            //通过当前线程的类加载器来加载指定包下的配置文件
            InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/res/comfig.properties");
//            InputStream inStream = new FileInputStream("/com/res/comfig.properties");
            p.load(inStream);
            username = p.getProperty("db.username");
            password = p.getProperty("db.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        writeConfig("Jack","654321");
        readConfig();
        System.out.println(propertyDemo.username);
        System.out.println(propertyDemo.password);
//        System.out.println("尖椒鸡");
    }
}
