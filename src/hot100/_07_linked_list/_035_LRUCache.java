package hot100._07_linked_list;

import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类： LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 int get(int key)
 * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * Last Modified:
 * @date 2025/2/9 15:55
 */
public class _035_LRUCache {
    /*
    关键在于：保证当缓存空间满了时，会优先淘汰掉最久未被使用的元素。不要使用已有的数据接口，所以双向链表和hashmap需要自己构建
    LRU 缓存机制可以通过哈希表辅以双向链表实现，我们用一个哈希表和一个双向链表维护所有在缓存中的键值对。
    双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
    哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
    这样以来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，随后将其移动到双向链表的头部，即可在 O(1) 的时间内完成 get 或者 put 操作。具体的方法如下：
     */

    //插入数据的时候要快速找到双向链表的头和尾巴，所以要自动维护头和尾巴,那么必须先维护一个虚拟头和尾巴，添加数据时自动更新头和尾巴
    public _035_LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new doubleLinkList();
        this.tail = new doubleLinkList();
        head.next = tail;
        tail.pre = head;
    }

    HashMap<Integer, doubleLinkList> map = new HashMap<>();
    doubleLinkList head;
    doubleLinkList tail;
    int capacity;

    //构造基本的双向链表
    class doubleLinkList {
        doubleLinkList pre;
        doubleLinkList next;
        int key;
        int value;

        public doubleLinkList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public doubleLinkList() {
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //要更新顺序，将这个放在最前面
            putHead(map.get(key));
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    //规定双向链表中尾巴是老数据
    public void put(int key, int value) {
        doubleLinkList node = new doubleLinkList(key, value);
        //首先判断这个元素是否存在，如果存在需要更新值，并且放到尾巴,同时需要保证容量没有超过
        if (!map.containsKey(key)) {
            //判断是否超载
            if (map.size() == this.capacity) {
                //此时需要移除末尾的过期数据
                map.remove(tail.pre.key);
                removeTail();
            }
            //新数据放在头
            putHead(node);
            map.put(key, node);
        } else {
            map.get(key).value=value;
            putHead(map.get(key));
        }
    }

    public void removeTail() {
        doubleLinkList newTail = this.tail.pre.pre;
        newTail.next = this.tail;
        this.tail.pre = newTail;
    }

    public void putHead(doubleLinkList node) {
        //数据要分为原本就在链表还是新数据插入头部
        if (node.pre != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }else {
            head.next.pre=node;
            node.next=head.next;
            head.next=node;
            node.pre=head;
        }
    }

    public static void main(String[] args) {
        _035_LRUCache lruCache = new _035_LRUCache(2);
        System.out.println(lruCache.get(2));//-1
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(3));//2
        lruCache.put(2, 22);
        System.out.println(lruCache.get(2));//22
        System.out.println(lruCache.get(5));//5
        lruCache.put(6, 6);
        System.out.println(lruCache.get(3));//-1
        System.out.println(lruCache.get(6));//6
    }
}

