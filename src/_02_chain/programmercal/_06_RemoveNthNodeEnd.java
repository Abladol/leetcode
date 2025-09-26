package _02_chain.programmercal;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目描述：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。输入的n不会大于链表的维数
 */
public class _06_RemoveNthNodeEnd {

    /**
     * 我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 n 个节点就是需要删除的节点，
     * 并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthNodeEnd(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null){
            deque.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        deque.getFirst().next = deque.getFirst().next.next;
        return dummy.next;
        
    }

    /**
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthNodeEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;

        }

        ListNode pre =dummy;
        while (fast!= null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;

        return dummy.next;
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
        System.out.println("删除前：" + head.toString());
        System.out.println("***********************");
        System.out.println("删除后：" + removeNthNodeEnd2(head, 7).toString());
    }
}
