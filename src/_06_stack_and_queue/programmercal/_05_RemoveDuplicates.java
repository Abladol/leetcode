package _06_stack_and_queue.programmercal;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class _05_RemoveDuplicates {
    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String res ="";
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek().equals(chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        for (char c : stack) {
            res=res+c;
        }
        return res;
}

    public static void main(String[] args) {
        System.out.println(removeDuplicates("ggabaa"));
    }


}
