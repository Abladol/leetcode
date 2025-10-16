package review_code;

import javax.management.MBeanAttributeInfo;
import java.util.Optional;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 最长公共前缀,编写一个函数来查找字符串数组中的最长公共前缀。  如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * Last Modified:
 * @date 2025/10/14 19:58
 */
public class _14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return res.toString();
                }
                if (j == strs.length - 1) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _14_LongestCommonPrefix longestCommonPrefix = new _14_LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "f", "flight"}));
    }
}

