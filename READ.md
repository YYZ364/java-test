### tips

两数交换高效方法（整数）

```java
 while (l < r) {
            l ^= r;  //构造 a ^ b 的结果，并放在 a 中
            r ^= l;  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            l ^= r;}
```

数组初始化：

```java
Arrays.fill(array, 0);
```



### 字符串

通常遍历字符串时，先将字符串转换为字符数组

s:字符串

Array:字符数组

char[] Array = s.toCharArray();

character 是一个包装类 character 类型的对象
包含一个类型为char的字段.此外,该类提供了几种方法来确定字符的类别(小写字母,数字等)以及将字符从大写转换为小写

StringBuilder:

字符串缓冲区，底层是一个没有被final修饰的数组，可以改变长度，可以提高字符串的操作效率

```java
        //String转换为StringBuilder
        StringBuilder builder = StringBuilder(str1);

		//向StringBuilder中添加字符串
		builder.append("World!");

		//StringBuilder转换为String
		String str2 = builder.toString();
```

#### 例子：

请实现一个函数，把字符串 `s` 中的每个空格替换成"%20"。 

**示例 1：**

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

```java
public String replaceSpace(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i < s.length();i++){
        if(s.charAt(i) == ' ')
            sb.append("%20");
        else
            sb.append(s.charAt(i));
    }
    return sb.toString();
}
```

### 回溯

算法模板框架：

```java
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
```

ArrayList：基于动态数组的数据结构。

LinkedList：内部使用基于链表的数据结构实现存储，



步骤：

1 确定回溯函数参数

2 确定终止条件

3 确定单层遍历逻辑



### 队列

- Deque双端队列

方法：

getLast(),getFirst(),addLast(),addFirst(),removeLast(),removeFirst()

last:队列入口

first:队列出口

- ArrayDeque 既可当作队列，也可当作堆栈

  队列：offer() poll()

  堆栈：push() pop()



```java
Queue<Integer>q = new LinkedList<Integer>();
q1.isEmpty();
rrayDeque<Integer> stack = new ArrayDeque<>();
stack.isEmpty();
inStack = new Stack<Integer>();
inStack.isEmpty();
Deque<Integer> deque = new ArrayDeque<>();
deque.isEmpty();
ArrayDeque<Character> result = new ArrayDeque<>();
result.isEmpty();
```

### 比较器：

比较器

比较器是个很神奇的东西，它可以使得某些对象在排序的时候按照我们设计的比较规则进行排序，比如`TreeMap`，`TreeSet`等等，那现在来看看优先队列中的比较器。

在进行入队的时候需要进行堆的调整，堆调整需要进行比较来判断需不需要对结点进行调整
比较器的的简单使用：

```java
//这种方式创建的优先队列和默认生成的优先队列是一样的，都是小顶堆
PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
```

![image-20230221193906232](../../../learnBySelf/MyBatis/img/image-20230221193906232.png)

![image-20230221193929256](../../../learnBySelf/MyBatis/img/image-20230221193929256.png)

![image-20230221193944311](../../../learnBySelf/MyBatis/img/image-20230221193944311.png)

小顶锥：前减后

大顶锥：后减前



Collections.reverse():颠倒作为参数传递的列表中元素的顺序。

埋点：二叉树层序遍历--dfs递归

Integer.valueOf('0') = 0;

Double.valueOf(12) = 12.000

Integer .MIN_VALUE

Math.max(a,b)



![image-20230315111923363](../../../learnBySelf/MyBatis/img/image-20230315111923363.png)





### HashMap 用法：

```java
public Object put(Object key,Object value):将指定的 key-value 映射添加到HashMap中;

public Object get(Object key): 返回指定键对应的值:

public void clear(): 从HashMap 中删除所有的元素;

public boolean containskey(Object key):判断HashMap 中是否存在指定键

public boolean containsvalue(Object value): 判断 HashMap 中是否存在指定

public boolean isEmpty():判断HashMap 是否为空;

public int size():返回 HashMap 中键值对的数目:

public Set keySet():返回HashMap 中所有键的集合:

public Set entrySet();返回集合中所有的value的值的集合
    
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hash.containsKey(nums[i])){
                hash.put(nums[i], hash.get(nums[i]) + 1);
            }
            else{
                hash.put(nums[i], 1);
            }
        }
        for(HashMap.Entry<Integer, Integer> entry : hash.entrySet()){
            if(entry.getValue() > (nums.length/2))
                return entry.getKey();
        }
        return 0;
    }
    
```

### HashSet用法：

不包含重复数据：

```java
Set<Integer> set = new HashSet<>();

1、add(Object obj)：向Set集合中添加元素，添加成功返回true，否则返回false。

2、size()：返回Set集合中的元素个数。

3、remove(Object obj)： 删除Set集合中的元素，删除成功返回true，否则返回false。

4、isEmpty()：如果Set不包含元素，则返回 true ，否则返回false。

5、clear()： 移除此Set中的所有元素。

6、iterator()：返回在此Set中的元素上进行迭代的迭代器。

7、contains(Object o)：如果Set包含指定的元素，则返回 true，否则返回false。

8、遍历
for(int i : resSet){
            arr[j++] = i;
        }
```

### LinkedList用法



```java
//最常用方法
    boolean add(E e)：在链表后添加一个元素，如果成功，返回true，否则返回false；
    getFirst()：获取第一个元素； 
    getLast()：获取最后一个元素；
    remove()；移除链表中第一个元素； 
    removeLast()：移除链表中最后一个元素； 
    contains(Object obj):判断链表中是否包含某个元素，返回值为true或false；
```



```Java
	//add方法
    boolean add(E e)：在链表后添加一个元素，如果成功，返回true，否则返回false； 
    void addFirst(E e)：在链表头部插入一个元素； 
    addLast(E e)：在链表尾部添加一个元素； 
    void add(int index, E element)：在指定位置插入一个元素。
    
	//get方法
    get(int index)：按照下边获取元素； 
    getFirst()：获取第一个元素； 
    getLast()：获取最后一个元素；
    
	//remove 、pop、poll移除方法
    remove()；移除链表中第一个元素； 
    boolean remove(Object o)：移除链表中指定的元素； 
    remove(int index)：移除链表中指定位置的元素； 
    removeFirst()：移除链表中第一个元素，与remove类似； 
    removeLast()：移除链表中最后一个元素； 
    boolean removeFirstOccurrence(Object o)：移除链表中第一次出现所在位置的元素； 
    boolean removeLastOccurrence(Object o)：移除链表中最后一次出现所在位置的元素；

    pop()：与removeFirst一样，实际上它就是removeFirst； 
    poll()：查询并移除第一个元素；
        
    //其他方法
    contains(Object obj):判断链表中是否包含某个元素，返回值为true或false；
	element():获得链表的第一个元素但不删除
	set(int position,Object obj):将链表中第position个元素修改为obj;
	subList(int start,int end):取中间元素，但顾头不顾尾；
```



### Q

- #### 浮点数运算精度丢失风险

​		原因：计算机保存浮点数的机制是将其保存为二进制，但其保存的二进制位数有限，对于循环小数只能将其截断，就会发生小数精度丢失的情况，这也就是为什么浮点数没法用二进制表示。

​		解决方法：https://javaguide.cn/java/basis/bigdecimal.html

#### 1、== 和equals()区别

​		1、因为 Java 只有值传递，所以，对于 == 来说，不管是比较基本数据类型，还是引用数据类型的变量，其本质比较的都是值，只是引用类型变量存的值是对象的地址。

​		2、**`equals()`** 不能用于判断基本数据类型的变量，只能用来判断两个对象是否相等。分为两种情况。

​		**类没有重写 `equals()`方法** ：通过`equals()`比较该类的两个对象时，**等价于通过“==”比较**这两个对象（比较的是对象的内存地址），使用的默认是 `Object`类`equals()`方法。

​		**类重写了 `equals()`方法** ：一般我们都重写 `equals()`方法来比较两个对象中的属性是否相等；若它们的属性相等，则返回 true(即，认为这两个对象相等)。

​		举例：

​		`String` 中的 `equals` 方法是被重写过的，比较的是对象的值。

​		当创建 `String` 类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，如果有就把它赋给当前引用。如果没有就在常量池中重新创建一个 `String` 对象。

#### 2、为什么重写 equals() 时必须重写 hashCode() 方法？

因为两个相等的对象的 `hashCode` 值必须是相等。也就是说如果 `equals` 方法判断两个对象是相等的，那这两个对象的 `hashCode` 值也要相等。

如果重写 `equals()` 时没有重写 `hashCode()` 方法的话就可能会导致 `equals` 方法判断是相等的两个对象，`hashCode` 值却不相等。

**思考** ：重写 `equals()` 时没有重写 `hashCode()` 方法的话，使用 `HashMap` 可能会出现什么问题。

**总结** ：

- `equals` 方法判断两个对象是相等的，那这两个对象的 `hashCode` 值也要相等。
- 两个对象有相同的 `hashCode` 值，他们也不一定是相等的（哈希碰撞）。

### 	JVM

![Java 运行时数据区域（JDK1.8 之后）](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/github/javaguide/java/jvm/java-runtime-data-areas-jdk1.8.png)

**线程私有的：**

- 程序计数器
- 虚拟机栈
- 本地方法栈

**线程共享的：**

- 堆
- 方法区
- 直接内存 (非运行时数据区的一部分)

#### 程序计数器：

​		线程私有，每条线程都需要有一个独立的程序计数器，各线程之间计数器互不影响。

生命周期：

​		随着线程的创建而创建，随着线程的结束而死亡。

- 字节码解释器通过改变程序计数器来依次读取指令，从而实现代码的流程控制，如：顺序执行、选择、循环、异常处理。
- 在多线程的情况下，程序计数器用于记录当前线程执行的位置，从而当线程被切换回来的时候能够知道该线程上次运行到哪儿了。

⚠️ 注意 ：程序计数器是唯一一个不会出现 `OutOfMemoryError` 的内存区域，它的生命周期随着线程的创建而创建，随着线程的结束而死亡。

#### Java 虚拟机栈

​		线程私有。

生命周期：

​		随着线程的创建而创建，随着线程的结束而死亡。

​		除了一些 Native 方法调用是通过本地方法栈实现的(后面会提到)，其他**所有的 Java 方法调用都是通过栈来实现的**（也需要和其他运行时数据区域比如程序计数器配合）。方法调用的数据需要通过栈进行传递，每一次方法调用都会有一个对应的栈帧被压入栈中，每一个方法调用结束后，都会有一个栈帧被弹出。

https://javaguide.cn/java/jvm/memory-area.html#%E7%A8%8B%E5%BA%8F%E8%AE%A1%E6%95%B0%E5%99%A8

动态链接

​		主要服务一个方法需要调用其他方法的场景。

​		Class 文件的常量池里保存有大量的符号引用比如方法引用的符号引用。

​		当一个方法要调用其他方法，需要将常量池中指向方法的符号引用转化为其在内存地址中的直接引用。

​		动态链接的作用就是为了将符号引用转换为调用方法的直接引用，这个过程也被称为 **动态连接**![img](https://guide-blog-images.oss-cn-shenzhen.aliyuncs.com/github/javaguide/jvmimage-20220331175738692.png)

#### 堆

​		Java 虚拟机所管理的内存中最大的一块，Java 堆是**所有线程共享**的一块内存区域，在虚拟机启动时创建。**此内存区域的唯一目的就是存放对象实例，几乎所有的对象实例以及数组都在这里分配内存。**

#### 方法区

​		方法区属于是 JVM 运行时数据区域的一块逻辑区域，**是各个线程共享**的内存区域。

​		当虚拟机要使用一个类时，它需要读取并解析 Class 文件获取相关信息，再将信息存入到方法区。方法区会存储已被虚拟机加载的 **类信息、字段信息、方法信息、常量、静态变量、即时编译器编译后的代码缓存等数据**。

#### 运行时常量池

​		功能类似于传统编程语言的符号表。

​		常量池表：用于存放编译期生成的各种字面量（Literal）和符号引用（Symbolic Reference）。

​		常量池表会在类加载后存放到方法区的运行时常量池中。

#### 字符串常量池

​		是 JVM 为了提升性能和减少内存消耗针对字符串（String 类）专门开辟的一块区域，主要目的是为了**避免字符串的重复创建**。

​		**`StringTable` 中保存的是字符串对象的引用，字符串对象的引用指向堆中的字符串对象。**

​		JDK1.7 之前，字符串常量池存放在永久代。JDK1.7 字符串常量池和静态变量从永久代移动了 Java 堆中。

**JDK 1.7 为什么要将字符串常量池移动到堆中？**

​		主要是因为永久代（方法区实现）的 GC 回收效率太低，只有在整堆收集 (Full GC)的时候才会被执行 GC。Java 程序中通常会有大量的被创建的字符串等待回收，将字符串常量池放到堆中，能够更高效及时地回收字符串内存。

#### 直接内存

​		直接内存是一种特殊的内存缓冲区，并不在 Java 堆或方法区中分配的，而是通过 JNI 的方式在本地内存上分配的。直接内存的分配不会受到 Java 堆的限制，但是，既然是内存就会受到本机总内存大小以及处理器寻址空间的限制。

HotSpot虚拟机对象

