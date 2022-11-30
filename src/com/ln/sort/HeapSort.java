package com.ln.sort;

import com.utils.Tools;

import javax.tools.Tool;
import java.util.Arrays;

/**
 * 堆排序 1:04:28
 */
public class HeapSort {//
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            heapInsert(arr,i);
        }
//        System.out.println("-------------");
        int heapSize = arr.length;
        Tools.swap2(arr,0,--heapSize);
        while(heapSize>0){
            heapify(arr,0,heapSize);
            Tools.swap2(arr,0,--heapSize);
//            Tools.printArray(arr);
        }
    }

    /**
     * 某个数现在处在index位置，往上继续移动 0：25：38
     * @param arr
     * @param index
     * 停止条件：1、来到一个位置我不再比父位置的数大了2、我到顶了来到0位置
     */
    public static void heapInsert(int[] arr,int index){
        while (arr[(index-1)/2]<arr[index]){
            Tools.swap2(arr,index,(index-1)/2);
            index = (index-1)/2;
//            Tools.printArray(arr);
        }
    }

    /**
     * 0:38:19
     * 某个数在index位置，能否往下移动
     */
    public static void heapify(int[] arr,int index,int heapSize){
        int left = 2*index + 1;
        while(left<heapSize){
            int largest = left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if(largest == index)
                break;
            Tools.swap2(arr,index,largest);
            index = largest;
            left = 2*index+1;
//            Tools.printArray(arr);
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i <testTime ; i++) {
            int [] arr1 = Tools.generateRandomArray(maxSize,maxValue);
            int [] arr2 = Tools.copyArray(arr1);
            heapSort(arr1);
            Tools.comparator(arr2);
            if (!Tools.isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed?"Nice":"Fucking fucked!");

        int[] arr = Tools.generateRandomArray(maxSize,maxValue);
        Tools.printArray(arr);
        heapSort(arr);
        Tools.printArray(arr);
        Arrays.sort(arr);
        Tools.printArray(arr);
    }
}
