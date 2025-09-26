package _02_chain.programmercal;


/**
 * 题目描述：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class _04_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            cur.next = res;
            res = cur;
            cur = temp;

        }
        return res;
    }


    public void test(){
        ListNode node7 = new ListNode(6);
        ListNode node6 = new ListNode(5, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = node1;
        System.out.println("翻转前："+ head.toString());
        System.out.println("*********************");
        System.out.println("翻转后："+ reverseList(head).toString());


    }
}
