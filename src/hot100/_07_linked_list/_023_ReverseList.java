package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * Last Modified:
 * @date 2025/1/18 15:50
 */
public class _023_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode reversed = reverseList(head.next);
        if (reversed != null) {
            node = reversed;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(head.val);
            return reversed;
        } else {
            return head;
        }
    }

    /*
    标准答案的递归方法比我的简便
     */
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }

    //这里面的res始终没有被替换，就是递归到最后一层的尾节点，也就是翻转后的头结点，每次递归的返回值都是同一个值
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }


    /*
    标准答案：双指针法
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }


    public static void main(String[] args) {
        // 创建链表A：a1 -> a2 -> c1 -> c2 -> c3
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;

        _023_ReverseList reverseList = new _023_ReverseList();
        ListNode reversed = reverseList.reverseList2(a1);
        System.out.println(reversed.toString());
    }
}

