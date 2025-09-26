package _02_chain.programmercal;


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 题目：链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class _07_ListIntersection {

    /**
     * 哈希集合法
     * 首先遍历链表 headA\textit{headA}headA，并将链表 headA\textit{headA}headA 中的每个节点加入哈希集合中。然后遍历链表 headB\textit{headB}headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
     * 如果当前节点不在哈希集合中，则继续遍历下一个节点；
     * 如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分，因此在链表 headB\textit{headB}headB 中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
     * 如果链表 headB\textit{headB}headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回 null\text{null}null。
     * @param headA
     * @param headB
     * @return
     */
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            Set<ListNode> visited = new HashSet<ListNode>();
            ListNode temp = headA;
            while (temp != null) {
                visited.add(temp);
                temp = temp.next;
            }
            temp = headB;
            while (temp != null) {
                if (visited.contains(temp)) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

    /**
     * 双指针法
     * 使用双指针的方法，可以将空间复杂度降至 O(1)O(1)O(1)。
     * 只有当链表 headA\textit{headA}headA 和 headB\textit{headB}headB 都不为空时，两个链表才可能相交。因此首先判断链表 headA\textit{headA}headA 和 headB\textit{headB}headB 是否为空，如果其中至少有一个链表为空，则两个链表一定不相交，返回 null\text{null}null。
     * 当链表 headA\textit{headA}headA 和 headB\textit{headB}headB 都不为空时，创建两个指针 pA\textit{pA}pA 和 pB\textit{pB}pB，初始时分别指向两个链表的头节点 headA\textit{headA}headA 和 headB\textit{headB}headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
     * 每步操作需要同时更新指针 pA\textit{pA}pA 和 pB\textit{pB}pB。
     * 如果指针 pA\textit{pA}pA 不为空，则将指针 pA\textit{pA}pA 移到下一个节点；如果指针 pB\textit{pB}pB 不为空，则将指针 pB\textit{pB}pB 移到下一个节点。
     * 如果指针 pA\textit{pA}pA 为空，则将指针 pA\textit{pA}pA 移到链表 headB\textit{headB}headB 的头节点；如果指针 pB\textit{pB}pB 为空，则将指针 pB\textit{pB}pB 移到链表 headA\textit{headA}headA 的头节点。
     * 当指针 pA\textit{pA}pA 和 pB\textit{pB}pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null\text{null}null。
     * @param headA
     * @param headB
     * @return
     */
    //直接简单理解为：
    //
    //如链表A+链表B=链表C1
    //
    //链表B+链表A=链表C2
    //
    //A -> a1 a2 c1 c2 c3
    //
    //B -> b1 b2 b3 c1 c2 c3
    //
    //C1 -> a1 a2 c1 c2 c3 b1 b2 b3 c1 c2 c3
    //
    //C2 -> b1 b2 b3 c1 c2 c3 a1 a2 c1 c2 c3
    //
    //此时C1和C2的长度一定相同。 而C1和C2的结尾就一定是相交的链表。

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Deque<ListNode> deque1 = new LinkedList();
        Deque<ListNode> deque2 = new LinkedList();

        ListNode dummy1 =new ListNode(-1);
        ListNode dummy2 =new ListNode(-2);
        dummy1.next = headA;
        dummy2.next = headB;

        ListNode cur1=dummy1;
        ListNode cur2=dummy2;
        while (cur1!=null){
            deque1.push(cur1);
            cur1=cur1.next;
        }
        while (cur2!=null){
            deque2.push(cur2);
            cur2=cur2.next;
        }
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            if (deque1.peek()!=deque2.peek()){
                break;
            }
            deque1.pop();
            deque2.pop();
        }
        return deque1.peek().next;
    }


    public void test() {
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head1 = node1;

        ListNode node7_ = new ListNode(-7);
        ListNode node3_ = new ListNode(-3, node7_);
        ListNode node2_ = new ListNode(-2, node3_);
        ListNode node1_ = new ListNode(-1, node2_);
        ListNode head1_ = node1_;

        System.out.println(getIntersectionNode(head1_, head1));


    }
}
