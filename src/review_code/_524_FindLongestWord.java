package review_code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 通过删除字母匹配到字典里最长单词,给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * Last Modified:
 * @date 2025/10/12 20:43
 */
public class _524_FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        int len = 0;
        String res = "";
        for (String dic : dictionary) {
            //逐个暴力匹配
            int l1 = 0;
            int l2 = 0;
            while (l1 < dic.length() && l2 < s.length()) {
                if (dic.charAt(l1) == s.charAt(l2)) {
                    l1++;
                    l2++;
                } else {
                    l2++;
                }
            }
            if (l1 >= dic.length()) {
                int dicLen = dic.length();
                if (dicLen > len) {
                    len = dicLen;
                    res = dic;
                } else if (dicLen == len) {
                    for (int i = 0; i < len; i++) {
                        if (dic.charAt(i) < res.charAt(i)) {
                            res = dic;
                            break;
                        } else if (dic.charAt(i) > res.charAt(i)){
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _524_FindLongestWord findLongestWord = new _524_FindLongestWord();
        List<String> list = new ArrayList<>();
        list.add("bpc");
        list.add("cle");
        list.add("monkey");
        list.add("plew");

        System.out.println(findLongestWord.findLongestWord("abpcplea", list));
    }
}

