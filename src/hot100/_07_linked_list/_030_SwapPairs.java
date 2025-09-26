package hot100._07_linked_list;

import hot100.ListNode;

import java.util.Stack;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * Last Modified:
 * @date 2025/2/7 13:48
 */
public class _030_SwapPairs {
    /*
    个人思路：个人思路就是暴力
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        //两个一组的前一个节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode res = new ListNode(-1);
        if (head == null || head.next == null) {
            return head;
        } else {
            res.next = head.next;
        }
        while (node != null && node.next != null) {
            ListNode exchangeNode = node.next;
            node.next = exchangeNode.next;
            exchangeNode.next = node;
            pre.next = exchangeNode;
            pre = pre.next.next;
            node = node.next;
        }
        return res.next;
    }


    /*
    官方思路：我的思路是迭代方法，比较复杂，官方思路提供了栈这个思路
    我们利用一个 stack，然后不断迭代链表，每次取出两个节点放入 stack 中，再从 stack 中拿出两个节点。
    借助 stack 后进先出的特点，放进去的时候是 1,2 。拿出来的时候就是 2，1 两个节点了。
    再把这两个节点串联起来，重复这个逻辑遍历完整个链表，就可以做到两两反转的效果了。
    虽然用到了 stack，但因为只存了两个元素，所以空间复杂度还是 O(1)，时间复杂度是 O(n)。
     */
    public ListNode swapPairs2(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        //用stack保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //head指向新的p节点，函数结束时返回head.next即可
        head = p;
        while(cur!=null && cur.next!=null) {
            //将两个节点放入stack中
            stack.add(cur);
            stack.add(cur.next);
            //当前节点往前走两步
            cur = cur.next.next;
            //从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件，当链表长度是奇数时，cur就不为空
        if(cur!=null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
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
//        c2.next = c3;

        _030_SwapPairs swapPairs = new _030_SwapPairs();
        System.out.println(swapPairs.swapPairs(a1).toString());
    }
}

