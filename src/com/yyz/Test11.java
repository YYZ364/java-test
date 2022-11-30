package com.yyz;

public class Test11 {
    public static void main(String[] args) {
        //使用者和被使用者之间，耦合，产生了依赖，当被使用者改变时，会影响使用者
        Product phone = ProductFactory.getProduct("phone");
//        Product phone = new Phone();
        phone.work();
    }
}

interface Product{
    public void work();
}

class Phone implements Product{
    @Override
    public void work() {
        System.out.println("手机");
    }
}

class Computer implements Product{
    @Override
    public void work() {
        System.out.println("电脑");
    }
}

class ProductFactory{
    public static Product getProduct(String name){
        if("phone".equals(name)){
            return new Phone();
        }
        else if("computer".equals(name)){
            return new Computer();
        }
        else{
            return null;
        }
    }
}