package com.ln.sort;

import java.util.Arrays;

/**
 * 与冒泡排序相反
 */
public class InsertSort {
    public static void insertSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=1;i<=arr.length-1;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int)(Math.random()*maxSize+1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*maxValue+1)-(int)(Math.random()*maxValue+1);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if (arr==null){
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if(arr1==null||arr2==null||arr1.length!=arr2.length){
            return false;
        }
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i <testTime ; i++) {
            int [] arr1 = generateRandomArray(maxSize,maxValue);
            int [] arr2 = copyArray(arr1);
            insertSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"Fucking fucked!");

        int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        insertSort(arr);
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
    }
}
