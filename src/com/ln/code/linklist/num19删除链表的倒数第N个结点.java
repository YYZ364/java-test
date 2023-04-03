package com.ln.code.linklist;

public class num19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //常规解法
//        int size = 0;
//        ListNode cur = head;
//        while(cur != null){
//            size ++;
//            cur = cur.next;
//        }
//        int index = size - n - 1;
//        cur = head;
//        if(index < 0){
//            return head.next;
//        }
//        while(index > 0){
//            cur = cur.next;
//            index--;
//        }
//        if(cur.next.next != null)
//            cur.next = cur.next.next;
//        else
//            cur.next = null;
//        return head;
        //双指针解法
        ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null)return head.next;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // if(slow.next.next != null){
        //     slow.next = slow.next.next;
        // }
        // else{
        //     slow.next = null;
        // }
        slow.next = slow.next.next;
        return head;
    }
}
