package com.ln.code;

import java.util.List;

/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class num203移除链表元素 {
    /**
     * 添加虚拟头
     * @param val
     * @param head
     * @return
     */
    public static ListNode removeElements(int val, ListNode head){
        if (head == null)
            return head;
        ListNode vitualHead = new ListNode(-1, head);
        ListNode pre = vitualHead;
        ListNode cur = head;
        while(cur != null){
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return vitualHead.next;
    }


    /**
     * 不添加虚拟头
     */
    public static ListNode removeElements1(int val, ListNode head){
        if (head == null)
            return head;
        while(head != null && head.val == val)
            head = head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加虚拟头和pre
     */
    public static ListNode removeElements2(int val, ListNode head){
        if (head == null)
            return head;
        while(head != null && head.val == val)
            head = head.next;
        ListNode cur = head;
        while (cur != null){
            while(cur.next!=null&& cur.next.val == val)
                cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }

    public static LinkNode remove(int val, LinkNode head){
        while(head!=null&&head.val==val){
            head = head.next;
        }
        if (head == null)
            return head;
        LinkNode cur = head;
        while(cur != null){
            while(cur.next!=null&&cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(6,null);
        ListNode head = new ListNode(-1, a);
        removeElements2(6,head);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}


