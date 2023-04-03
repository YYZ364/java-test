package com.ln.code.hash;

import org.junit.Test;

public class num202快乐数 {
    public boolean isHappy(int n) {
        if(n == 1)return true;
        int temp = n;
        while(temp != 1){
            temp = toNum(temp);
            if(temp == 1){
                return true;
            }
            else if(temp < 10)
                return false;
        }
        return false;
    }

    public int toNum(int num){
        int sum = 0;
        while(num != 0){
            int tem = num % 10;
            sum += tem * tem;
            num /= 10;
        }
        return sum;
    }

    @Test
    public void test(){
        isHappy(19);
    }
}
