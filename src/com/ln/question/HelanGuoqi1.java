package com.ln.question;

import com.utils.Tools;

import java.util.Arrays;

/**
 * 给定一个数组arr，和一个数number，请把小于等于number的数放在数组的左边，大于number的数放在数组的右边。要求额外空间复杂度o(1)，时间复杂o(N)
 *
 * 给定一个小于等于区，从第一个元素与num比较
 * 如果arr[i]<=num,则这个数与小于等于区下一个数做交换,小于等于区右移一个，i++
 * 如果arr[i]>num,i++
 */
public class HelanGuoqi1 {
    public static int[] helanGuoqi(int[] arr,int num){
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<= num){
                Tools.swap2(arr,p++,i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,7,4,3,5,8};
        Tools.printArray(helanGuoqi(arr,5));
    }
}
