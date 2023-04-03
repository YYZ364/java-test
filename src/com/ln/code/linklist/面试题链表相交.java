package com.ln.code.linklist;

public class 面试题链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null||headB == null) return null;
        ListNode curA = headA, curB = headB;
        int lenA = 0,lenB = 0;
        while(curA != null){
            lenA ++;
            curA = curA.next;
        }
        while(curB != null){
            lenB ++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if(lenA < lenB){
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int chazhi = lenA - lenB;
        while(chazhi > 0){
            curA = curA.next;
            chazhi--;
        }
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
