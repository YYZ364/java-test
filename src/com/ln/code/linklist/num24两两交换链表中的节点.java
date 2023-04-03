package com.ln.code.linklist;

import org.junit.Test;

public class num24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null) return head;
        ListNode preHead = new ListNode(-1, head);
        ListNode cur = preHead, firstNode, secondNode, temp;
        while(cur.next != null&&cur.next.next != null){
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return preHead.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs(head);
    }
}
