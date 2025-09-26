package hot100._07_linked_list;

import hot100.ListNode;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * Last Modified:
 * @date 2025/1/21 13:59
 */
public class _027_MergeTwoLists {
    /*
    我的思路：用两个指针，分别比较大小，然后构建一个新的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode n1 = list1;
        ListNode n2 = list2;
        ListNode res = new ListNode(0);
        ListNode node = res;
        while (true) {
            //n1是空的，直接返回n2
            if (n1 == null) {
                node.next = n2;
                break;
            } else if (n2 == null) {
                node.next = n1;
                break;
            } else {
                //比较他们的大小，选小的
                if (n1.val < n2.val) {
                    node.next = new ListNode(n1.val);
                    n1 = n1.next;
                } else {
                    node.next = new ListNode(n2.val);
                    n2 = n2.next;
                }
                node = node.next;
            }
        }
        return res.next;
    }

    /*
    官方答案：思路差不多一致，在我的思路上可以简化为两个指针
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
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

        _027_MergeTwoLists mergeTwoLists = new _027_MergeTwoLists();
        System.out.println(mergeTwoLists.mergeTwoLists(a1, c1));
    }
}

