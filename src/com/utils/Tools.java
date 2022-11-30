package com.utils;

import java.util.Arrays;

public class Tools {
    public static void swap1(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap2(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
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

    public static void printArraySelf(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
