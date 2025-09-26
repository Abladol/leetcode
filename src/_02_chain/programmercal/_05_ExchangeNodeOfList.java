package _02_chain.programmercal;

/**
 * 题目描述：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实陳实际的进行节点交换。
 */

public class _05_ExchangeNodeOfList {
    public ListNode swapPairs(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        ListNode swapHead = new ListNode(-1);
        ListNode temp;

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (head.next != null) {
            swapHead = head.next;
        }

        while (head != null && head.next != null) {
            dumpy.next = head.next;
            temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            dumpy = head;
            head = head.next;
        }


        return swapHead;
    }

    /**
     * 递归方法
     */

        public ListNode swapPairs1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }

    /**
     * 迭代方法
     */
        public ListNode swapPairs2(ListNode head) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode temp = dummyHead;
            while (temp.next != null && temp.next.next != null) {
                ListNode node1 = temp.next;
                ListNode node2 = temp.next.next;
                temp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                temp = node1;
            }
            return dummyHead.next;
        }

    public void test() {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = node1;
        System.out.println("交换前：" + head.toString());
        System.out.println("*********************");
        System.out.println("交换后：" + swapPairs(head).toString());
    }
}
