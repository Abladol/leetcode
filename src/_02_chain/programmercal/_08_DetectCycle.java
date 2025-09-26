package _02_chain.programmercal;

/**
 * 题目描述：
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 */
public class _08_DetectCycle {
    /**
     * https://leetcode.cn/problems/linked-list-cycle-ii/solutions/441131/huan-xing-lian-biao-ii-by-leetcode-solution
     * 解题思路：快慢指针
     * 我们使用两个指针，fast\textit{fast}fast 与 slow\textit{slow}slow。它们起始都位于链表的头部。随后，slow\textit{slow}slow 指针每次向后移动一个位置，而 fast\textit{fast}fast 指针向后移动两个位置。如果链表中存在环，则 fast\textit{fast}fast 指针最终将再次与 slow\textit{slow}slow 指针在环中相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }


    /**
     * 自己的解法，也是快慢指针，可以看视频课
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = new ListNode(-1);
        ListNode slow = new ListNode(-1);
        fast.next = head;
        slow.next = head;

        //没有环
        if (fast.next == null || fast.next.next == null) {
            return null;
        }

        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //没有环
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            //此时的fast和slow就是交汇点
            if (fast == slow) {
                fast = fast.next;  //这是因为我们是从head前一个节点开始走的
                while (true) {
                    if (fast == head) break;
                    else {
                        fast = fast.next;
                        head = head.next;
                    }
                }
                break;
            }
        }
        //存在环

        return fast;
    }


}
