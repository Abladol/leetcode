package hot100._07_linked_list;

import hot100.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * Last Modified:
 * @date 2025/2/8 13:20
 */
public class _031_ReverseKGroup {
    /*
    我的思路：构造一个栈，需要翻转k个，就放k个进去，然后取出来
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while (true) {
            while (node != null && stack.size() < k) {
                stack.offerFirst(node);
                node = node.next;
            }
            //如果栈不足k个，不需要调换
            if(stack.size()<k){
                break;
            }
            //开始进行翻转
            while (!stack.isEmpty()){
                pre.next=stack.pollFirst();
                pre=pre.next;
            }
            pre.next=node;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
        c1.next = c2;
        c2.next = c3;

        _031_ReverseKGroup reverseKGroup = new _031_ReverseKGroup();
        System.out.println(reverseKGroup.reverseKGroup(a1, 4).toString());
    }
}

