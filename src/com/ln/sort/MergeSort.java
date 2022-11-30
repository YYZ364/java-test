package com.ln.sort;

import com.utils.Tools;

import java.util.Arrays;

/**
 * 归并排序
 * 算法时间复杂度o(n*log(n))
 * 1）整体就是一个简单递归，左边排好序、右边排好序、让其整体有序
 * 2）让其整体有序的过程里用了排外序方法
 * 3）利用master公式来求解时间复杂度
 * 4）归并排序的实质
 *      时间复杂度O(N*logN)，额外空间复杂度O(N)
 */
public class MergeSort {
    public static void process(int[] arr,int L,int R){
        if (L==R)
            return;
        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int M,int R){
        int[] temp = new int[R-L+1];
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        while (p1<=M&&p2<=R){
            temp[i++] = arr[p1]<=arr[p2]?arr[p1++] :arr[p2++];
        }
        while(p1<=M){
            temp[i++] = arr[p1++];
        }
        while(p2<=R){
            temp[i++] = arr[p2++];
        }
        System.arraycopy(temp, 0, arr, L, temp.length);
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i <testTime ; i++) {
            int [] arr1 = Tools.generateRandomArray(maxSize,maxValue);
            int [] arr2 = Tools.copyArray(arr1);
            process(arr1,0,arr1.length-1);
            Tools.comparator(arr2);
            if (!Tools.isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"Fucking fucked!");
        int[] arr = Tools.generateRandomArray(maxSize,maxValue);
        Tools.printArray(arr);
        process(arr,0, arr.length-1);
        Tools.printArray(arr);
        Arrays.sort(arr);
        Tools.printArray(arr);
    }
}
