package com.ln.question;

import com.utils.Tools;

/**时间复杂度 o(n)------master公式
 *递归的方式获取最大值
 */

public class GetMaxRecursion {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if (L==R)
            return arr[L];
        int mid = L+((R-L)>>1);
        System.out.println(mid);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr = Tools.generateRandomArray(10, 100);
        System.out.println(getMax(arr));
        Tools.printArray(arr);
    }
}
