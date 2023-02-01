package com.ln.code;

public class num2011执行操作后的变量值 {

    public int finalResult (String[] options){
        int x = 0;
        for (String option : options) {
            if (option.equals("X++") || option.equals("++X"))
                x++;
            else
                x--;
        }
        return x;
    }
}
