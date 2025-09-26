package _02_chain.programmercal;

/**
 * 题目描述：
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * <p>
 * 实现 MyLinkedList 类：
 * <p>
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */

public class _03_MyLinkedList {

    ListNode dummyHead;


    public _03_MyLinkedList() {
        dummyHead = new ListNode(-1);
    }

    public int get(int index) {
        ListNode temp = dummyHead;
        if (count() > index) {
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                return temp.val;
            }
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = dummyHead.next;
        dummyHead.next = temp;
    }

    public void addAtTail(int val) {
        ListNode temp = dummyHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        ListNode temp = dummyHead;
        if (index == 0) {
            addAtHead(val);
        } else if (count() >= index) {
            //确保添加节点有效，找到上一个节点
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = new ListNode(val, temp.next);
        }
    }


    public void deleteAtIndex(int index) {
        ListNode temp = dummyHead;
        if (count() > index) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public int count() {
        ListNode temp = dummyHead;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void mySolution() {
        _03_MyLinkedList myLinkedList = new _03_MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.dummyHead.next.toString());
        myLinkedList.addAtIndex(0, 2);
        System.out.println(myLinkedList.dummyHead.next.toString());
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(3);
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.dummyHead.next.toString());
    }
}


