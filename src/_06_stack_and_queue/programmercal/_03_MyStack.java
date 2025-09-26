package _06_stack_and_queue.programmercal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 */
public class _03_MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.empty());
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.empty());
        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
    }


}

class MyStack {
    /**
     * 在Java中，Queue 是一个接口，不是一个具体的类。这意味着你不能直接使用 new 关键字来创建一个 Queue 的实例，因为接口本身不包含实现。
     * 相反，你需要使用实现了 Queue 接口的类来创建实例。
     *
     * LinkedList 是Java标准库中的一个类，它实现了 List 接口，并且也提供了 Queue 接口的实现（通过实现 Deque 接口，而 Deque 是 Queue
     * 的一个子接口）。因此，你可以使用 new LinkedList<>() 来创建一个 LinkedList 的实例，这个实例可以作为 Queue 来使用，因为它实现了
     * Queue 接口。
     *
     * 这就是为什么你会看到 private Queue<Integer> queue = new LinkedList<>(); 而不是 new Queue<>()。new LinkedList<>() 创建
     * 了一个 LinkedList 的实例，并将其赋值给了一个 Queue 类型的引用变量 queue。由于 LinkedList 实现了 Queue 接口，所以这是合法的。
     *
     * 总结一下，你不能使用 new Queue<>()，因为 Queue 是一个接口，不是一个类。你需要使用实现了 Queue 接口的类（如 LinkedList）来创建实例。
     */
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        queue2stack();
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }

    public int top() {
        queue2stack();
        int x;
        if (!queue.isEmpty()) {
            x = queue.peek();
            queue.add(queue.poll());
            return x;
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void queue2stack() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }
}

