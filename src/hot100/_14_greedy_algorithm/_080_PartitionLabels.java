package hot100._14_greedy_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。  返回一个表示每个字符串片段的长度的列表。
 * <p>
 * Last Modified:
 * @date 2025/9/5 16:38
 */
public class _080_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int[] zm = new int[26];
        List<Integer> res = new ArrayList<>();
        int maxInstance = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            zm[chars[i] - 'a'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            maxInstance = Math.max(maxInstance, zm[chars[i] - 'a']);
            if (i < maxInstance) {
                continue;
            }
            res.add(maxInstance - start + 1);
            start = i + 1;
        }
        return res;
    }
}

