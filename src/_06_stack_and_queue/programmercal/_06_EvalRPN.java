package _06_stack_and_queue.programmercal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 */
public class _06_EvalRPN {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        int invid;
        for (String token : tokens) {
            if (token.equals("+")) {
                //注意：add是加载栈的尾巴上，也就是栈底，push才是入栈
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                invid = stack.pop();
                stack.push(stack.pop() / invid);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.peek();

    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));


    }


}
