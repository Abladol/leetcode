package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * Last Modified:
 * @date 2025/2/8 14:30
 */
public class _033_SortList {
    /*
    参考答案的归并排序
     */
    public ListNode sortList(ListNode head) {
        //递归到只有一个的时候，不用递归了
        if (head==null ||head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        //分成两个部分
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        //开始合并
        ListNode mergeHead = new ListNode(0);
        ListNode merge = mergeHead;
        while (left != null && right != null) {
            merge.next = new ListNode(Math.min(left.val, right.val));
            //判断选取的是左还是右
            if (left.val < right.val) {
                left = left.next;
            } else {
                right = right.next;
            }
            merge = merge.next;
        }
        merge.next = left == null ? right : left;
        return mergeHead.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(9);
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(2);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
        c1.next = c2;
        c2.next = c3;
        _033_SortList sortList = new _033_SortList();
        System.out.println(sortList.sortList(a1).toString());
    }
}

