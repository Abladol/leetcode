package hot100._10_backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Last Modified:
 * @date 2025/2/19 20:22
 */
public class _059_GenerateParenthesis {
    /*
    我的思路：这个问题其实很好理解，我们就是遍历一个数组[(,)]这里面每个元素可以重复用，排列问题，长度为2*n
    排列问题，需要标记使用过的元素，但是这里是重复用，所以不需要标记，从0遍历
     */
    private List<String> res = new ArrayList<>();
    private StringBuffer s = new StringBuffer();
    private int[] count = new int[2];

    public List<String> generateParenthesis(int n) {
        retrace(new char[]{'(', ')'}, 2 * n);
        return res;
    }

    public void retrace(char[] chars, int n) {
        if (s.length() == n) {
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            //还要保证括号的有效性，可以记录左括号和右括号个数
            if (i == 0) {
                if (count[0] < n / 2) count[0]++;
                else continue;
            } else {
                if (count[0] > count[1]) count[1]++;
                else continue;
            }
            s.append(chars[i]);
            retrace(chars, n);
            char deleted = s.charAt(s.length()-1);
            s.deleteCharAt(s.length() - 1);
            if (Character.valueOf(deleted).equals('(')) count[0]--;
            else count[1]--;
        }
    }

    public static void main(String[] args) {
        _059_GenerateParenthesis generateParenthesis = new _059_GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}

