### 快速幂求法

```java
/**
     * 快速幂
     * @param x 底数
     * @param n 指数
     * @param m 模
     * @return (x^n)%n
     */
    public static long fastMi(long x, long n, long m) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % m;
            }
            x = (x * x) % m;
            n /= 2;
        }
        return res;
    }
```

### 并查集

```java
class UF{
    private int count;
    private int[] parent;
    public UF(int n){
        count = n;
        parent = new int[n];
        for(int i = 0;i < n; i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public boolean connected(int p, int q){
        int rootQ = find(q);
        int rootP = find(p);
        return rootP == rootQ;
    }
    public int count(){
        return count;
    }
}
```

### k个一组反转链表

```java
//迭代方法 反转以head为头结点的链表
public ListNode reverse(ListNode head){
    ListNode pre, cur, nxt;
    cur = head;
    pre = null;
    while(cur != null){
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    //返回反转后的头节点
    return pre;
}
```

```java
//递归算法

//首先 实现一个函数 实现反转节点a到b之间的节点
/** 反转区间 [a, b) 的元素，注意是左闭右开 */
public ListNode reverse(ListNode a, ListNode b){
    ListNode pre = null,cur = a, nxt;
    while(cur != b){
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    return pre;
}
//递归
public ListNode reverseGroup(ListNode head, k){
    if(head == null){
        return head;
    }
    ListNode a = head, b = head;
    for(int i = 0;i < K;i++){
        if(b == null){
            return head;
        }
        b = b.next;
    }
    ListNode newHead = reverse(a,b);
    a.next = reverseGroup(b, k);
    return newHead;
}
```

### 反转链表：递归

```java
// 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode last = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return last;
}
```
