package com.ln.code.linklist;

public class num707设计链表 {

}

class LinkNode{
    public int val;
    public LinkNode next;
    LinkNode(){};
    LinkNode(int val){
        this.val = val;
    }
}

class MyLinkedList{
    int size;
    LinkNode head;
    public MyLinkedList() {
        size = 0;
        head = new LinkNode(-1);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index){
        if (index < 0 || index >= size)
            return -1;
        LinkNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
//        System.out.println("第" + index + "位置上的元素为" + cur.val);
        return cur.val;
    }

    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val){
        LinkNode cur = new LinkNode(val);
        cur.next = head.next;
        head.next = cur;
        size ++;
    }


    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前
    public void addAtTail(int val){
        LinkNode temp = new LinkNode(val);
//        System.out.println(temp.next);
        if (size == 0){
            head.next = temp;
            temp.next = null;
        }
        else{
            LinkNode cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = temp;
            temp.next = null;
        }
        size ++;
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int value){
        if (index > size)
            return;
        if (index < 0)
            index = 0;
        if(index == 0)
            addAtHead(value);
        else if (index == size){
            addAtTail(value);
        }
        else {
            LinkNode cur = head;
            LinkNode temp = new LinkNode(value);
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
            size ++;
        }
    }

    public void deleteAtIndex(int index){
        LinkNode cur = head;
        if(index < 0||index >= size)
            return;
        if(index == 0)
            head = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if(index ==size - 1)
            cur.next = null;
        else
            cur.next = cur.next.next;
        size --;
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
        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(1);
//        obj.addAtTail(2);
        obj.addAtTail(1);
        obj.addAtTail(2);
        obj.addAtTail(3);
//        obj.addAtIndex(2,5);
//        obj.addAtIndex(1,3);
//        obj.addAtIndex(1,3);
//        obj.deleteAtIndex(0);
        remove(1, obj.head.next);
        int index = 0;
        LinkNode cur  = obj.head.next;
        System.out.println("链表大小为:" + obj.size);
        while(cur != null) {
            obj.get(index);
            System.out.println("第" + index++ +"个元素 :" + cur.val);
            cur = cur.next;
        }
    }



}