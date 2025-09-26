package hot100;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 第32题提出的链表增加一个随机指针
 * <p>
 * Last Modified:
 * @date 2025/2/8 13:39
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}

