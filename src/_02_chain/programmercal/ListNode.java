package _02_chain.programmercal;

/**
 * 定义链表节点类
 * @author AiJun
 */
public class ListNode {
    public int val;
    public ListNode next;

    // 构造函数：仅设置节点值
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // 构造函数：设置节点值和指向的下一个节点
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
