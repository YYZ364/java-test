package com.ln.question;


import com.utils.Tools;

/**
 * 给定一个数组arr，和一个数number，请把小于number的数放在数组的左边，等于number的数放在数组的中间，大于number的数放在数组的右边。要求额外空间复杂度o(1)，时间复杂度o(N)
 *  给定一个大于区，一个小于区
 *  从数组第一个元素开始遍历，
 *  如果arr[i]<num,当前数与小于等于区下一个数做交换，i++，小于等于区右移一个
 *  如果arr[i]=num,i++
 *  如果arr[i]>num,当前数与大于等于区前一个数做交换，大于等于区左移一个
 */
public class HelanGuoqi2 {
    public static int[] helanGuoqi(int[] arr, int num){
        int p1 = 0;
        int p2 = arr.length - 1;
        int i = 0;
        while(i < arr.length&&i <=p2){
            if(arr[i]<num){
                Tools.swap2(arr,p1++,i);
                i++;
//                System.out.println("i="+i+",p1="+p1+",p2="+p2);
//                Tools.printArray(arr);
            }
            else if (arr[i]==num)
            {
                i++;
//                System.out.println("i="+i+",p1="+p1+",p2="+p2);Tools.printArray(arr);
            }
            else if (arr[i]>num)
            {
                Tools.swap2(arr,i,p2--);
//                System.out.println("i="+i+",p1="+p1+",p2="+p2);Tools.printArray(arr);
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,7,4,3,5,8};
        Tools.printArray(helanGuoqi(arr,5));
    }
}
