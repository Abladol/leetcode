package _06_stack_and_queue.programmercal;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */

/**
 * 主要考虑的问题：
 * 1.什么时候满足true的条件，一个是字符串所有元素检查完，一个是栈是空的
 * 2.栈如果是空的，我们进行pop操作会出现空指针异常，对栈进行操作时一定要时刻判断是否是空栈
 */
public class _04_IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            switch (chars[i]) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (stack.empty() || chars[i] != stack.pop()) {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }
}
