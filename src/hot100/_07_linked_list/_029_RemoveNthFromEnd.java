package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * Last DAMified:
 * @date 2025/2/7 13:27
 */
public class _029_RemoveNthFromEnd {
    /*
    个人思路：使用递归，递归到最后开始计数，然后删除，返回
     */
    private int count = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = retrace(root, n);
        return node.next;
    }

    public ListNode retrace(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node = retrace(head.next, n);
        if (count == n) {
            head.next = node.next;
            //这是因为当删除那个节点之后，这个if仍然满足
            count++;
        } else {
            count++;
        }
        return head;
    }

    /*
    官方思路：上面的思路可以解决问题，但不够巧妙，官方解答很巧妙：
    整体思路是让前面的指针先移动 n 步，之后前后指针共同移动直到前面的指针到尾部为止
    首先设立预先指针 pre，预先指针是一个小技巧，在第 2 题中进行了讲解
    设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
    start 先向前移动n步
    之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
    因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
    删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }


    public static void main(String[] args) {
        _029_RemoveNthFromEnd removeNthFromEnd = new _029_RemoveNthFromEnd();
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
        ListNode node = removeNthFromEnd.removeNthFromEnd(a1, 7);
        System.out.println(node.toString());
    }
}

