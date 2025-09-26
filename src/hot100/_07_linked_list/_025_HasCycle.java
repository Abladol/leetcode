package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * Last Modified:
 * @date 2025/1/19 12:50
 */
public class _025_HasCycle {
    /*
    我的思路：使用快慢指针，如果有环，快指针会追上慢指针，没有环的话，会遍历到null，不能直接判断是否可以遍历到null，因为你无法判断需要遍历多少次
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /*
    标准答案：也是快慢指针，思路完全一致
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        _025_HasCycle hasCycle = new _025_HasCycle();
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
        System.out.println(hasCycle.hasCycle(c3));
    }
}

