package _06_stack_and_queue.programmercal;


import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class _02_MyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
        queue.push(1);
        System.out.println(queue.empty());
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {
    private final Stack<Integer> stackIn = new Stack<>();
    private final Stack<Integer> stackOut = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        in2Out(stackIn, stackOut);
        return stackOut.pop();
    }

    public int peek() {
        in2Out(stackIn, stackOut);
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    //如果out空了，就将in给out
    public void in2Out(Stack stackIn, Stack stackOut) {
        if(stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
