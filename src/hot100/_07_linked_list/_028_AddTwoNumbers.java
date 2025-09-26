package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。  请你将两个数相加，并以相同形式返回一个表示和的链表。  你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * Last Modified:
 * @date 2025/1/21 14:42
 */
public class _028_AddTwoNumbers {
    /*
    我的思路是构造加法器
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        int flag = 0;
        int num;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                num = l1.val + l2.val + flag;
            } else {
                num = l1 == null ? l2.val + flag : l1.val + flag;
            }
            node.next = new ListNode(num % 10);
            node = node.next;
            flag = num / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag != 0) {
            node.next = new ListNode(flag);
        }
        return res.next;
    }

    /*
    标准答案和我的思路一样，无非是对于长度不一样的链表末尾补0，而我是先一步进行判断
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(9);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        c1.next = c2;
        c2.next = c3;

        _028_AddTwoNumbers addTwoNumbers = new _028_AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(a1, c1));
    }
}

