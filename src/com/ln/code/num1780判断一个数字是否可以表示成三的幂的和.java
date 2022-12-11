package com.ln.code;

import java.lang.reflect.Array;
import java.util.Arrays;

public class num1780判断一个数字是否可以表示成三的幂的和 {
    public static boolean checkSum(int n){
        int[] arr = new int[15];
        arr[0] = 1;
        int chengji = 1;
        for (int i = 1;i <= 14;i++){
            chengji *= 3;
            arr[i] = chengji;
        }
        /**
         * 判断n是不是3的幂 是的话直接返回true
         * 不是的话 判断 n与左侧相邻数的差是不是3的幂 然后将比较数组截止到前一位
         * 是的话 返回true 不是的话 继续判断 缩小数组
         * 直到 比较数组大小缩减为0
         */
        int last = 14;
        if (n - arr[leftIndexOfNum(n,arr,last)] == 0)
            return true;
        while(n - arr[leftIndexOfNum(n,arr,last)] != 0){
            last = leftIndexOfNum(n,arr,last);
            int cha = n - arr[last];
            last = last - 1;
            n = cha;
            if (last < 0)
                break;
            if (n - arr[leftIndexOfNum(n,arr,last)] == 0||cha ==0)
                return true;
        }
        return n == 0;
    }

    public static int[] indexOfNumMin(int n,int[] arr){
        int left = 0;
        int right = 14;
        int[] res = new int[2];
        res[0] = -1;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] == n){
                res[1] = middle;
                res[0] = 1;
                break;
            }
            else if (arr[middle] > n)
                right = middle - 1;
            else if (arr[middle] < n)
                left = middle + 1;
        }
        if (res[0] == -1)
            res[0] = 0;
        return res;
    }

    public static int indexOfNum(int n,int[] arr){
        int left = 0;
        int right = 14;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] == n){
                return middle;
            }
            else if (arr[middle] > n)
                right = middle - 1;
            else if (arr[middle] < n)
                left = middle + 1;
        }
        return -1;
    }

    public static int leftIndexOfNum(int n,int[] arr,int last){
        int left = 0;
        int right = last;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] == n){
                return middle;
            }
            else if (arr[middle] > n)
                right = middle - 1;
            else if (arr[middle] < n)
                left = middle + 1;
        }
        return left - 1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[15];
//        arr[0] = 1;
//        int chengji = 1;
//        for (int i = 1;i <= 14;i++){
//            chengji *= 3;
//            arr[i] = chengji;
//        }

        System.out.println(checkSum(27));
        System.out.println(checkSum(12));
        System.out.println(checkSum(91));
        System.out.println(checkSum(21));
//        System.out.println(indexOfNum(arr[14],arr));
//        int[] res = indexOfNumMin(27, arr);
//        System.out.println();
//        System.out.println(Arrays.toString(res));
//        System.out.println(leftIndexOfNum(9,arr));
    }
}
