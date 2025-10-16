package review_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 计数二进制子串,给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * <p>
 * Last Modified:
 * @date 2025/10/15 20:23
 */
public class _696_CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        //思路比较新奇,我们统计连续出现的0和1的个数，然后对于计数的数组取相邻元素的最小值就是子串个数，
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        char preNum = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (preNum == s.charAt(i)) {
                cnt++;
            } else {
                preNum = s.charAt(i);
                list.add(cnt);
                cnt = 1;
            }
        }
        //最后一个数
        list.add(cnt);
        int res = 0;
        if (list.size() == 1) {
            return list.get(0);
        }
        for (int i = 1; i < list.size(); i++) {
            res += Math.min(list.get(i), list.get(i - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        _696_CountBinarySubstrings countBinarySubstrings = new _696_CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110011"));
    }
}

