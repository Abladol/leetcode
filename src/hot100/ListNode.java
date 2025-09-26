package hot100;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 链表定义
 * <p>
 * Last Modified:
 * @date 2025/1/18 13:23
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

