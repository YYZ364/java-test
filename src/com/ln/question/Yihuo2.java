package com.ln.question;


/**
 * Q:
 * 现有一个数组int[];
 * 1、一种数出现了奇数次，其余数偶数次，找出这个奇数次的数？
 * 2、两种数出现了奇数次，其余数偶数次，找出这两个奇数次的数？
 *
 * A:
 * 1、所有数字异或一遍，存在eor(int)中，eor(int)即为所求。
 * 2、 (1)eor = a ^ b != 0(从头异或到尾)它一定有一位不为0，说明a和b在这一位一定不一样。(比如第八位)
 *     (2)eor'只异或上第八位不为1的数，那么最终得到的eor'会得到a或者b
 *     (3)再用eor" = eor ^ eor'就得到b或者a
 */
public class Yihuo2 {
    public static void printOddNum2(int[] arr){
        int eor = 0;
        for (int j : arr) {
            eor = eor ^ j;
        }
        int rightOne = eor &( ~eor + 1);//提取出最右边的1
        int eor1 = 0;
        for(int cur:arr){
            if((cur&rightOne)==0){
                eor1 =  eor1 ^ cur;
            }
        }
        System.out.println(eor1);
        System.out.println((eor^eor1));
    }

    public static void prinytOddNum(int[] arr){
        int eor = 0;
        for (int j:arr){
            eor^=j;
        }
        System.out.println(eor);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,4,4,4,4,4,4,3,3,3,3,3};
        printOddNum2(arr);
        int[] arr1 = {1,1,2,2,2,2,2,3,3,3,3};
        prinytOddNum(arr1);
    }
}
