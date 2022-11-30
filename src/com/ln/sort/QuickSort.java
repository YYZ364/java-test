package com.ln.sort;

import com.utils.Tools;

import java.util.Arrays;

/**
 * 快速排序3.0版本
 * 每次把最后一个数作为num,将数组分为左边全为小于等于num的数，右边全为大于num的数，然后将最后这个num与大于区第一个数做交换
 * 在每个分区重复这样的过程
 *
 * 空间复杂度o(N)时间复杂度log(N)
 */
public class QuickSort {
    public static void quickSort(int[] arr,int L,int R){
        if(L<R){
            Tools.swap2(arr,R,L+(int)(Math.random()*(R-L+1)));
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    public static int[] partition(int[] arr,int L,int R){
        int[] p = {0,0};
        int less = L-1;
        int more = R;
        while(L<more){
            if (arr[L] < arr[R]){
                Tools.swap2(arr,L,++less);
                L++;
            }
            else if(arr[L] == arr[R])
                L++;
            else if (arr[L]>arr[R])
                Tools.swap2(arr,--more,L);
        }
        Tools.swap2(arr,more,R);
        p[0]=less+1;
        p[1]=more;
        return p;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i <testTime ; i++) {
            int [] arr1 = Tools.generateRandomArray(maxSize,maxValue);
            int [] arr2 = Tools.copyArray(arr1);
            quickSort(arr1,0, arr1.length-1);
            Tools.comparator(arr2);
            if (!Tools.isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"Fucking fucked!");

        int[] arr = Tools.generateRandomArray(maxSize,maxValue);
        Tools.printArray(arr);
        quickSort(arr,0,arr.length-1);
        Tools.printArray(arr);
        Arrays.sort(arr);
        Tools.printArray(arr);
    }
}

