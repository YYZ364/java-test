package com.ln.question;

/**
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。
 *
 * merge 的时候要先判断逆序对 再排序 是为了方便计算下次merge的时候判断逆序对 如果先排序再判断 结果会出错
 */
public class GeReversePair {
    public static int getReversePair(int[] arr){
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
//            res += arr[p1]>arr[p2]?(R-p2+1):0;
            if(arr[p1]>arr[p2]) {
                System.out.println("("+arr[p1]+","+arr[p2]+")");
                res++;
            }
            temp[i++] = arr[p1]>arr[p2]?arr[p1++] :arr[p2++];
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
        System.out.println("逆序对如下：");
        System.out.println("逆序对数目为："+getReversePair(arr));
    }
}
