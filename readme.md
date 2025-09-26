# leetcode

## 踩到的坑

### 递归调用时，形参的作用范围不清晰

这是写代码随想录，孤岛面积计算遇到一个问题，在实现孤岛面积计算时，我使用 `flag` 作为标志来判定是否为孤岛，主要逻辑是：

- 如果岛屿是孤岛，则将 `flag` 设置为 `true`，在后续的 BFS 操作中可以进行面积的累加。
- 如果发现岛屿接触边界，则将 `flag` 设置为 `false`，后续的面积计算应为 0。

按照这个思路，我预期 `flag` 作为形参传递，在递归过程中可以正确判断和更新岛屿的状态。然而，问题在于 **`flag` 是作为形参传递的，而面积是通过全局变量 `temp` 来累加的**，导致递归过程中的状态传递出现了问题。

### **问题分析**

考虑以下递归链：A -> B -> C -> D 或 B -> E。假设 A 和 B 是不与边界相连的陆地，C 和 D 与边界相连。

- 当递归到 C 时，会判断出该部分岛屿接触边界，因此 `flag` 被设置为 `false`。
- 但是，由于递归是链式的，D 会继承 C 的 `flag` 值，表明整个岛屿已经不是孤岛。因此，C 到 D 之间的岛屿正确地标记为非孤岛。

问题出现在 **回溯的过程中**，A 和 B 在递归时仍然保持 `flag` 为 `true`，即它们被误判为孤岛，仍然参与面积累加。更糟糕的是，B 到 E 的递归也传递了 `true` 的 `flag`，导致本应被忽略的区域仍然被计算入面积。

### **解决方法**

最初，我尝试使用递归传递 `flag` 作为形参，但由于递归过程的反向跳出，会导致前面的递归状态（如 A 和 B）被错误地保留。最终，我选择将 `flag` 改为全局变量来解决这个问题。

### **总结**

1. **形参传递的局限性**：递归函数中的 `flag` 作为形参传递，在回溯过程中可能会导致递归调用之间的状态共享，从而影响岛屿的判断。
2. **全局变量的使用**：为了避免递归过程中 `flag` 被错误传递，我选择将 `flag` 作为全局变量。这样，无论递归如何跳出，都能确保 `flag` 的状态是正确的，不会被提前设置为错误的值。
3. **注意递归的状态传递**：在递归中，特别是在回溯过程中，需要格外小心地传递状态（如 `flag` 和 `temp`），确保每一层递归调用都有独立的状态，避免影响其他递归分支的计算。

```java
  public static void DFS(int x, int y, boolean flag) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + DIR[i][0];
            int nextY = y + DIR[i][1];
            //判断是否超出边际以及是否是陆地
            if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length || matrix[nextX][nextY] == 0) {
                continue;
            } else if (!flag || nextX == 0 || nextX == matrix.length - 1 || nextY == 0 || nextY == matrix[0].length - 1) {
                matrix[nextX][nextY] = 0;
                temp=0;
                DFS(nextX, nextY, false);
            } else {
                matrix[nextX][nextY] = 0;
                temp++;
                DFS(nextX, nextY, true);
            }
        }
    }
```



## String和Byte[]

需要将Byte[]数组转为一个string，`使用String newStr= new String(sBytes);`即可



## 栈的思想

当我们要找到倒数第n个时，可以使用栈，例如[下题](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/)，

`给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。`

思路与算法

我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
```





## 环形问题

当遇到一个数组，告诉我们这个数组可以首尾相连成环，有以下两个思路：

思路一：扩展数组，将数组扩展到原来长度两倍

思路二：对于思路一存在空间问题，所以我们可以采用取模的方式，for循环时，遍历到原数组的两倍，取i的时候，改为取i取模数组长度

## 题型

> #### **倒数第n个元素**

栈：我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。



双指针：由于我们需要找到倒数第 *n* 个节点，因此我们可以使用两个指针 *first* 和 *second*同时对链表进行遍历，并且 *first* 比 *second* 超前 *n* 个节点。当 *first* 遍历到链表的末尾时，*second*就恰好处于倒数第 *n* 个节点。



> #### **可能会无限循环，需要找到一个数是否在一个集合里**

**什么时候使用哈希法**，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。





## 二叉树

### 二叉树的遍历

如果希望二叉树从下向上遍历，就要使用后序遍历

如果希望二叉树从上向下遍历，就要使用前序遍历



### 树的深度与数的高度

计算树的深度的时候，是从根节点到该节点的距离，所以要采用前序遍历

计算树的高度的时候，是从叶子节点到该节点的距离，所以要采取后序遍历

`其中，树的最大深度，就是计算根节点的高度，采取后序遍历`



### 二叉搜索树

二叉搜索树中序遍历是递增的

## 背包问题

### 01背包

**递推公式：**一维（物品从前向后遍历，背包从后向前遍历）或者二维

`物品从前向后遍历，背包从后向前遍历：这样可以保证每一个物品只能取一次`

**遍历顺序：**先物品或背包；先背包或物品（没有区分）



### 完全背包

**递推公式：**一维（物品从前向后遍历，背包从前向后遍历）

`物品从前向后遍历，背包从前向后遍历：这样可以保证物品取任意个`

**组合问题和排列问题：**

组合问题：先遍历物品后遍历背包：`保证了物品的顺序始终是从第0个到最后一个`

排列问题：先遍历背包再遍历物品：`物品的顺序是不一样的`

**最小个数问题**：需要计算满足背包的最少方法

dp数组初始化从第1个开始要尽量大，后续填充dp数组时使用min判断

```java
int max = Integer.MAX_VALUE;
int[] dp = new int[amount + 1];
//初始化dp数组为最大值
for (int j = 0; j < dp.length; j++) {
    dp[j] = max;
}
//遍历
for (int i = 0; i < coins.length; i++) {
    //正序遍历：完全背包每个硬币可以选择多次
    for (int j = coins[i]; j <= amount; j++) {
        //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
        if (dp[j - coins[i]] != max) {
            //选择硬币数目最小的情况
            dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
    }
}
```





# MySQL

## 问题汇总：

[使用条件查询时，查询的很慢，效率很低，实际上是由于隐式转换导致索引失效的问题](#索引失效)

## **MySQL 日志**

### slow query log（慢查询日志）

### undo log（回滚日志）：1.回滚使用；2.MVCC 



## 索引失效

当 where 查询操作符**左边为字符类型**时发生了隐式转换，那么会导致索引失效，造成全表扫描效率极低。因为左边是字符类型，mysql进行匹配时自动转为浮点型进行比较，转换规则为：

`**不以数字开头**的字符串都将转换为0。如'abc'、'a123bc'、'abc123'都会转化为0；`

`**以数字开头的**字符串转换时会进行截取，从第一个字符截取到第一个非数字内容为止。比如'123abc'会转换为123，'012abc'会转换为012也就是12，'5.3a66b78c'会转换为5.3，其他同理。`

这样就会导致索引失效（索引不唯一），所以查询效率很低，当 where 查询操作符**左边为数值类型**时发生了隐式转换，那么对效率影响不大。



## MySQL 概述

### having与where

```mysql
SELECT cust_name, COUNT(*) AS NumberOfOrders
FROM Customers
WHERE cust_email IS NOT NULL
GROUP BY cust_name
HAVING COUNT(*) > 1;
```

**`having`**：

- `having` 用于对汇总的 `group by` 结果进行过滤。
- `having` 一般都是和 `group by` 连用。
- `where` 和 `having` 可以在相同的查询中。

**`having` vs `where`**：

- `where`：过滤过滤指定的行，后面不能加聚合函数（分组函数）。`where` 在`group by` 前。
- `having`：过滤分组，一般都是和 `group by` 连用，不能单独使用。`having` 在 `group by` 之后。



### JOIN

总结：

- **`INNER JOIN`**：只返回匹配的数据。
- **`LEFT JOIN`**：返回左表所有行，右表没有匹配时返回 `NULL`。
- **`RIGHT JOIN`**：返回右表所有行，左表没有匹配时返回 `NULL`。
- **`FULL OUTER JOIN`**：返回两个表的所有行，没匹配的返回 `NULL`。
- **`CROSS JOIN`**：返回笛卡尔积，所有行组合。

```SQL
SELECT * FROM table1 INNER JOIN table2 ON table1.id = table2.id;
SELECT * FROM table1 LEFT JOIN table2 ON table1.id = table2.id;
SELECT * FROM table1 RIGHT JOIN table2 ON table1.id = table2.id;
SELECT * FROM table1 FULL OUT JOIN table2 ON table1.id = table2.id;
SELECT * FROM table1 CROSS JOIN table2;
```



### [为什么不推荐使用 TEXT 和 BLOB？](https://javaguide.cn/database/mysql/mysql-questions-01.html#为什么不推荐使用-text-和-blob)

TEXT 类型类似于 CHAR（0-255 字节）和 VARCHAR（0-65,535 字节），但可以存储更长的字符串，即长文本数据，例如博客内容。

| 类型       | 可存储大小           | 用途           |
| ---------- | -------------------- | -------------- |
| TINYTEXT   | 0-255 字节           | 一般文本字符串 |
| TEXT       | 0-65,535 字节        | 长文本字符串   |
| MEDIUMTEXT | 0-16,772,150 字节    | 较大文本数据   |
| LONGTEXT   | 0-4,294,967,295 字节 | 极大文本数据   |

BLOB 类型主要用于存储二进制大对象，例如图片、音视频等文件。

| 类型       | 可存储大小 | 用途                     |
| ---------- | ---------- | ------------------------ |
| TINYBLOB   | 0-255 字节 | 短文本二进制字符串       |
| BLOB       | 0-65KB     | 二进制字符串             |
| MEDIUMBLOB | 0-16MB     | 二进制形式的长文本数据   |
| LONGBLOB   | 0-4GB      | 二进制形式的极大文本数据 |

在日常开发中，很少使用 TEXT 类型，但偶尔会用到，而 BLOB 类型则基本不常用。如果预期长度范围可以通过 VARCHAR 来满足，建议避免使用 TEXT。

数据库规范通常不推荐使用 BLOB 和 TEXT 类型，这两种类型具有一些缺点和限制，例如：

- 不能有默认值。
- 在使用临时表时无法使用内存临时表，只能在磁盘上创建临时表（《高性能 MySQL》书中有提到）。
- 检索效率较低。
- 不能直接创建索引，需要指定前缀长度。
- 可能会消耗大量的网络和 IO 带宽。
- 可能导致表上的 DML 操作变慢。
- ……



### [NULL 和 '' 的区别是什么？](#null-和-的区别是什么)

`NULL` 跟 `''`(空字符串)是两个完全不一样的值，区别如下：

- `NULL` 代表一个不确定的值,就算是两个 `NULL`,它俩也不一定相等。例如，`SELECT NULL=NULL`的结果为 false，但是在我们使用`DISTINCT`,`GROUP BY`,`ORDER BY`时,`NULL`又被认为是相等的。
- `''`的长度是 0，是不占用空间的，而`NULL` 是需要占用空间的。
- `NULL` 会影响聚合函数的结果。例如，`SUM`、`AVG`、`MIN`、`MAX` 等聚合函数会忽略 `NULL` 值。 `COUNT` 的处理方式取决于参数的类型。如果参数是 `*`(`COUNT(*)`)，则会统计所有的记录数，包括 `NULL` 值；如果参数是某个字段名(`COUNT(列名)`)，则会忽略 `NULL` 值，只统计非空值的个数。
- 查询 `NULL` 值时，必须使用 `IS NULL` 或 `IS NOT NULLl` 来判断，而不能使用 =、!=、 <、> 之类的比较运算符。而`''`是可以使用这些比较运算符的。

 ==`MySQL 不建议使用 NULL 作为列默认值`==
