package com.ln.code;

import java.util.Stack;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class num206反转链表 {
    public static LinkNode reverseList(LinkNode head){
        /**
         * 双指针法
         */
        if(head == null || head.next ==null)
            return head;
        LinkNode temp = null;
        LinkNode cur = head;
        LinkNode pre = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        /**
         * 递归法
         */


        return pre;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtTail(1);
        obj.addAtTail(2);
        obj.addAtTail(3);
        obj.addAtTail(4);
        obj.addAtTail(5);
        LinkNode cur1= obj.head.next;
        while (cur1 != null){
            System.out.println(cur1.val);
            cur1 = cur1.next;
        }
//        obj.addAtIndex(2,5);
//        obj.addAtIndex(1,3);
//        obj.addAtIndex(1,3);
//        obj.deleteAtIndex(0);
        LinkNode head = obj.head.next;
        LinkNode cur= reverseList(head);
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
