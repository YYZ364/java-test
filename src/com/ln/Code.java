package com.ln;

import com.utils.Tools;

import java.util.Arrays;
import java.util.Stack;

public class Code {
    /**
     * 搜索有序数组插入位置
     * @param nums
     * @param target
     * @return
     */
    public static int search3(int[] nums,int target){
        if(target < nums[0] ){
            return 0;
        }
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                return middle;
            }
            else if (nums[middle] > target){
                right = middle - 1;
            }
            else if (nums[middle] < target){
                left =  middle + 1;
            }
        }
        return left;
    }

    /**
     * 有序数组右边界
     * @param nums
     * @param target
     * @return
     */
    public static int getRight(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if(nums[middle] <= target){
                left = middle + 1;
                rightBorder = left;
            }
            else{
                right = middle - 1;
            }
        }
        return rightBorder;
    }


    /**
     * 返回有序数组左边界
     * @param nums
     * @param target
     * @return
     */
    public static int getLeft(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if(nums[middle] >= target){
                right = middle - 1;
                leftBorder = right;
            }
            else{
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    /**
     * 在排序数组中，查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target){
        int rightBorder = getRight(nums , target);
        int leftBorder = getLeft(nums , target);
        if(rightBorder == -2 || leftBorder == -2)
            return new int[]{-1,-1};
        if(rightBorder - leftBorder > 1)
            return new int[]{leftBorder + 1,rightBorder - 1};
        return new int[]{-1,-1};
    }

    /**
     * 平方根
     * @param x
     * @return
     */
    public static int mySqrt(int x){
        if(x == 1||x == 0){
            return x;
        }
        int left = 1;
        int right = x;
        while (left <= right){
            int middle = left + ((right - left)>>1);
            if(middle == x / middle){
                return middle;
            }
            else if (middle  > (x / middle)){
                right = middle - 1;
            }
            else if (middle  < (x / middle)){
                if((middle+1)>(x/(middle +1)))
                    return middle;
                left = middle + 1;
            }
        }
        return 0;
    }

    /**
     * 判断完全平方数
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int left = 1;
        int right = num;
        while (left <= right){
            int middle = left + ((right - left)>>1);
            if(middle < (double)num / middle){
                left = middle + 1;
            }
            else if(middle > (double)(num / middle)){
                right = middle - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * 完全平方数对数器
     * @param num
     * @return
     */
    public static boolean test(int num){
        for(int i=1;i<=num/2;i++){
            if(i*i == num)
                return true;
        }
        return false;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        int fastIndex = 0;
        for (fastIndex = 0; fastIndex <= nums.length - 1; fastIndex++) {
            if(nums[fastIndex] == val){
                nums[slowIndex++] = nums[fastIndex];
            }
            else{
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return -1;
    }

    /**
     * 给你一个 升序排列的数组 nums ，请你原地删除重复出现的元素，使每个元素
     * 只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持 一致
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        int k = nums.length;
        if(k == 0){
            return 0;
        }
        int slowIndex = 0;
        for(int fastIndex = 1;fastIndex < k;fastIndex ++){
            if(nums[fastIndex] != nums[fastIndex - 1]){
                nums[slowIndex++] = nums[fastIndex - 1];
                if(fastIndex + 1 == k)
                    nums[slowIndex] = nums[fastIndex];
            }
            else {
                if(fastIndex + 1 == k){
                    nums[slowIndex] = nums[fastIndex - 1];
                }
            }
        }
        return slowIndex + 1;
    }

    /**
     * 给你一个 升序排列的数组 nums ，请你原地删除重复出现的元素，使每个元素
     * 只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持 一致
     * @param nums
     * @return
     */


    /**
     *默认第一个元素肯定在 只需要从第二个元素开始遍历即可
     */
    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        if(k == 0){
            return 0;
        }
        int slowIndex = 1;
        for(int fastIndex = 1;fastIndex < k;fastIndex ++){
            if(nums[fastIndex] != nums[fastIndex - 1]){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。
     * # 代表退格字符。
     * @param s 字符串
     * @param t 字符串
     * @return 是否一致
     */
    public static boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }

    /**
     * 利用栈结构来解答
     * @param s
     * @return
     */
    public static String process(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '#'){
                if (stack.size()!=0)
                    stack.pop();
            }
            else {
                stack.push(chars[i]);
            }
        }
        return stack.toString();
    }



    public static void main(String[] args) {

        String s = "a";
        String t = "ac######kkkdkfkdkfkdf#";
//        System.out.println(process(s));
        System.out.println(process(t));
        System.out.println(backspaceCompare(s,t));
//        int testTime = 50;
//        boolean success = true;
//        for (int i = 0; i <testTime ; i++) {
//            int t = (int)(Math.random()*(Math.pow(2,31)-1));
////            int t = (int)(Math.random()*(100));
//            boolean r1 = isPerfectSquare(t);
//            boolean r2 = test(t);
////            System.out.println("t = "+t+";r1 = "+r1+"; r2 = "+r2);
////            System.out.println("t = "+t+";r1 = "+r1+"; r2 = "+r2);
//            if(r1!=r2){
//                System.out.println("t = "+t+";r1 = "+r1+"; r2 = "+r2);
//                success = false;
//                break;
//            }
//        }
//        System.out.println(success?"sucess!":"defeat!");
    }



}
