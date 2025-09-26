package hot100._12_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * Last Modified:
 * @date 2025/3/1 21:01
 */
public class _070_MinStack {
    /*
    官方思路：栈是先进后出的，所以只有最小的在里面那么每次找最小的就永远是那个，所以我们构造一个辅助栈，栈顶永远存储当前时候最小值
     */
    private static Deque<Integer> stack;
    private static Deque<Integer> auxiStack;

    public _070_MinStack() {
        stack = new LinkedList<>();
        auxiStack = new LinkedList<>();
    }

    public void push(int val) {
        if (!auxiStack.isEmpty()) {
            Integer peek = auxiStack.peek();
            auxiStack.push(Math.min(peek, val));
        } else {
            auxiStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        auxiStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxiStack.peek();
    }

    public static void main(String[] args) {
        _070_MinStack minStack = new _070_MinStack();
        minStack.push(2);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        minStack.push(3);
        minStack.push(7);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

