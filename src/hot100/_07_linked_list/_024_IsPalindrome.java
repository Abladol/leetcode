package hot100._07_linked_list;

import hot100.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个单链表的头节点 head ，请你判断该链表是否为 回文链表 。
 * 回文 序列是向前和向后读都相同的序列。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * Last Modified:
 * @date 2025/1/19 11:48
 */
public class _024_IsPalindrome {
    /*
    我的想法是先遍历这个链表，放到一个队列里面存储数值，然后递归的时候一个一个比对，如果符合说明是，这个时间复杂度应该是2n
     */
    /*
    官方答案提供了三种思路，前两种和我的想法一致
    第一种是先遍历链表的值存到数组中，然后遍历数组判断是否回文，这个方法比我使用栈要节约时间和空间，思路大题一致
    第二种方法，使用递归，效率没有第一种方法高，不推荐
    第三种方法是，将链表分为两个部分，我们将后面部分进行翻转，如果是回文链表，那么反转后和前一段是一致的，这里面要注意的一点是如何将链表一份为二
                这里面常用的方法是快慢指针，就是一个指针的速度是另一个指针速度的两倍，快指针到达尾部的时候，慢指针正好到达中间，这就是快慢指针的思想
     */
    private Deque<Integer> queue = new LinkedList<>();

    public boolean isPalindrome(ListNode head) {
        return retrace(head);
    }

    public boolean retrace(ListNode node){
        if(node==null){
            return true;
        }
        queue.offerFirst(node.val);
        boolean flag = retrace(node.next);
        if(!flag){
            return false;
        }else {
            //判断队列最后一个也就是最前面的节点和现在尾部的节点是不是一样的
            return Objects.equals(queue.pollLast(), node.val);
        }
    }

    public static void main(String[] args) {
        _024_IsPalindrome isPalindrome = new _024_IsPalindrome();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(2);
        ListNode c3 = new ListNode(2);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;
        System.out.println(isPalindrome.isPalindrome(c1));
    }
}

