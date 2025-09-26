package hot100._12_stack;

import javax.swing.*;
import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：  左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * Last Modified:
 * @date 2025/3/1 20:45
 */
public class _069_IsValid {
    /*
    我的思路：问题关键在于正确的顺序闭合，可以使用栈，先进后出
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character poll = stack.poll();
                if (!((poll == '(' && c == ')') || (poll == '[' && c == ']') || (poll == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        _069_IsValid isValid =new _069_IsValid();
        System.out.println(isValid.isValid(s));
    }
}

