package hot100._12_stack;

import java.util.Stack;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * Last Modified:
 * @date 2025/3/21 15:00
 */
public class _071_DecodeString {
    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        int temp=0;
        char[] cc = s.toCharArray();
        int count = 0;
        for (char c : cc) {
            if (Character.isDigit(c)) {
                count = Integer.parseInt(String.valueOf(c));
            } else {
                if (count != 0 && c != '[' && c != ']') {
                    sb.append(c);
                    temp++;
                } else if (c == ']') {
                    String t= sb.substring(sb.length()-temp,sb.length());
                    for (int i = 0; i < count-1; i++) {
                        sb.append(t);
                    }
                    temp=0;
                    count=0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _071_DecodeString decodeString = new _071_DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }
}

