package com.ln.question;

/**
 * 小和问题
 *
 * 在一个数组中，每一个数左边比当前小的数数累加起来，叫做这个数组的小和。求一个数组的小和。
 * 例子:[1,3,4,2,5]1左边比1小的数，没有;3左边比3小的数，1;4左边比4小的数，1、3;2左边
 * 比2小的数，1;5左边比5小的数，1、3、4、2;所以小和为1+1+3+1+1+3+4+2=16
 *
 * 以1为例 右边有多少个数比1大就产生多少个1的小和
 *
 *
 * merge 的时候要先计算小和 再排序 是为了方便计算下次merge的时候计算小和  如果颠倒，结果会出错*/
public class GetSmallSum {
    public static int getSmallSum(int[] arr){
        return process(arr,0, arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if (L==R)
            return 0;
        int mid = L+((R-L)>>1);
        return process(arr,L,mid)+
        process(arr,mid+1,R)+
        merge(arr,L,mid,R);
    }

    public static int merge(int[] arr,int L,int M,int R){
        int[] temp = new int[R-L+1];
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        int res = 0;
        while (p1<=M&&p2<=R){
            res+=arr[p1]<arr[p2]?arr[p1]*(R-p2+1) :0;
            temp[i++] = arr[p1]<arr[p2]?arr[p1++] :arr[p2++];
        }
        while(p1<=M){
            temp[i++] = arr[p1++];
        }
        while(p2<=R){
            temp[i++] = arr[p2++];
        }
        System.arraycopy(temp, 0, arr, L, temp.length);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(getSmallSum(arr));
    }
}
