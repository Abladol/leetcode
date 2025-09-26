package hot100._07_linked_list;


import hot100.Node;

import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。  用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。 random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * Last Modified:
 * @date 2025/2/8 13:37
 */
public class _032_CopyRandomList {
    /*
    我的思路：因为随机指针不知道指向那个节点，所以如果根据随机指针创建节点可能会不全，我一开始的想法是遍历两遍
    但是random无法确认指向可以考虑存起来
     */
    public Node copyRandomList(Node head) {
        Node oldNode = head;
        Node newNode = new Node(0);
        Node newHead = newNode;
        HashMap<Node, Node> olad2new = new HashMap<>();
        if (head != null) {
            newNode.val = head.val;
            olad2new.put(oldNode, newNode);
            oldNode = oldNode.next;
        } else {
            return null;
        }
        //完成普通链表的拷贝,
        while (oldNode != null) {
            newNode.next = new Node(oldNode.val);
            newNode = newNode.next;
            olad2new.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        //进行随机指针的拷贝
        oldNode = head;
        newNode = newHead;
        while (oldNode != null) {
            newNode.random = olad2new.get(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    /*
    参考官方答案：考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，
    如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = n2;
        n2.random = n3;

        _032_CopyRandomList copyRandomList = new _032_CopyRandomList();
        System.out.println(copyRandomList.copyRandomList(n1).toString());
    }
}

