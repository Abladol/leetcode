package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * Last Modified:
 * @date 2025/1/18 13:22
 */
public class _022_GetIntersectionNode {

    /*
    这道题很巧妙，很难想到思路
    个人思路：假设相交，从尾部开始一定是一样的，因为这是单向链表，所以无法找到父节点，可以尝试使用递归，找到最尾部。
    实现后发现很麻烦，因为要确保两个递归，实现起来很麻烦，所以直接使用官方思路，双指针法：先让一个指针走到一个链表的尾部，然后让这个指针的下一个指向另一个链表的头部，
    然后两个指针一起后移，其实就是每个指针走的路程是一样的，都是两个链表的长度和减去公共长度和，所以指针会相遇，相遇的点就是交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        _022_GetIntersectionNode getIntersectionNode = new _022_GetIntersectionNode();

        // 创建链表A：a1 -> a2 -> c1 -> c2 -> c3
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;

        // 创建链表B：b1 -> b2 -> b3 -> c1 -> c2 -> c3
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(7);
        ListNode b3 = new ListNode(8);
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        // 测试链表是否有交点
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(c2, c3);

        // 输出交点
        if (intersectionNode != null) {
            System.out.println("相交的节点值为: " + intersectionNode.val);
        } else {
            System.out.println("两个链表没有相交");
        }
    }


}

