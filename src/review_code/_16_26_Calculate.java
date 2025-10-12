package review_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * Last Modified:
 * @date 2025/10/9 12:02
 */
public class _16_26_Calculate {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            if(Character.isDigit(chs[i])){
                num = num * 10 + chs[i] - '0';
            }else {

            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}

