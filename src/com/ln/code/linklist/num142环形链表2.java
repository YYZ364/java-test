package com.ln.code.linklist;

import org.junit.Test;

public class num142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        //判断是否是环形链表
        ListNode fast = head, slow = head;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            else return null;
            if(fast == slow){
                break;
            }
            if(fast == null)
                return null;
        }
        //寻找交点
        ListNode cur = head;
        while(cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
    @Test
    public void test(){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(0);
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = head.next;
        detectCycle(head);
    }
}
