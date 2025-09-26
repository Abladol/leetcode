package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。  不允许修改 链表。
 * <p>
 * Last Modified:
 * @date 2025/1/19 13:10
 */
public class _026_DetectCycle {
    /*
    这道题比较巧妙，我是根据官方解析写出的代码：
    在本题的求解过程中，双指针会产生两次“相遇”。

    双指针的第一次相遇：
    设两指针 fast，slow 指向链表头部 head 。
    令 fast 每轮走 2 步，slow 每轮走 1 步。
    执行以上两步后，可能出现两种结果：

    第一种结果： fast 指针走过链表末端，说明链表无环，此时直接返回 null。

    如果链表存在环，则双指针一定会相遇。因为每走 1 轮，fast 与 slow 的间距 +1，fast 一定会追上 slow 。

    第二种结果： 当fast == slow时， 两指针在环中第一次相遇。下面分析此时 fast 与 slow 走过的步数关系：

    设链表共有 a+b 个节点，其中 链表头部到链表入口 有 a 个节点（不计链表入口节点）， 链表环 有 b 个节点（这里需要注意，a 和 b 是未知数，例如图解上链表 a=4 , b=5）；设两指针分别走了 f，s 步，则有：

    fast 走的步数是 slow 步数的 2 倍，即 f=2s；（解析： fast 每轮走 2 步）
    fast 比 slow 多走了 n 个环的长度，即 f=s+nb；（ 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）。
    将以上两式相减得到 f=2nb，s=nb，即 fast 和 slow 指针分别走了 2n，n 个环的周长。

    接下来该怎么做呢？

    如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb ，即先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点。而目前 slow 指针走了 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。

    但是我们不知道 a 的值，该怎么办？依然是使用双指针法。考虑构建一个指针，此指针需要有以下性质：此指针和 slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头节点head。

    双指针第二次相遇：
    令 fast 重新指向链表头部节点。此时 f=0，s=nb 。
    slow 和 fast 同时每轮向前走 1 步。
    当 fast 指针走到 f=a 步时，slow 指针走到 s=a+nb 步。此时两指针重合，并同时指向链表环入口，返回 slow 指向的节点即可。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (slow != null) {
                slow = slow.next;
            } else {
                return null;

            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            //第一次相遇,慢指针再走a，就会到达入口
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                break;
            }
        }
        return slow;
    }

    /*
    标准答案：
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(2);
        ListNode c3 = new ListNode(2);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
//        c3.next = c1;

        _026_DetectCycle detectCycle = new _026_DetectCycle();
        ListNode node = detectCycle.detectCycle(a1);
        System.out.println(node == null ? null : node.val);
    }
}

