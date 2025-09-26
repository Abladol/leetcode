package hot100._07_linked_list;

import hot100.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个链表数组，每个链表都已经按升序排列。  请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * Last Modified:
 * @date 2025/2/9 14:36
 */
public class _034_MergeKLists {
    /*
    本人思路：第一想法是暴力，一个一个依次比较，可以使用优先级队列
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode res = new ListNode(-1);
        ListNode node = res;
        //先放k个进去
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode polledNode = queue.poll();
            node.next = polledNode;
            node = node.next;
            if (polledNode.next != null) {
                queue.add(polledNode.next);
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(9);
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(11);
        ListNode b3 = new ListNode(12);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(10);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        c1.next = c2;
        c2.next = c3;

        _034_MergeKLists mergeKLists = new _034_MergeKLists();
        ListNode[] listNodes= new ListNode[]{a1,b1,c1};
        System.out.println(mergeKLists.mergeKLists(listNodes).toString());
    }
}

