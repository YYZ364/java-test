package com.ln.code.linklist;

public class num86分隔链表 {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 断开原链表中的每个节点的 next 指针
            // ListNode temp = p.next;
            // p.next = null;
            // p = temp;
            p = p.next;
        }
        // 连接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode temp = new ListNode(2);
        ListNode cur = head;
        while(cur != null){
            if(cur.val == temp.val){
                System.out.println(cur.val);
            }
            cur = cur.next;
        }
    }
}
