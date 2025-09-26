package hot100._03_sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定两个字符串 s 和 p，找到 s 中所有 p 的  异位词  的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * Last Modified:
 * @date 2024/12/19 9:07
 */
public class _009_FindAnagrams {
    /**
     * 个人思路：类似于双指针，左边标志遍历的开始，右边属于内部遍历
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] words = new int[26];
        for (char c : pp) {
            words[c - 'a']++;
        }
        while (i <= ss.length - pp.length) {
            int[] subs = new int[26];
            for (int j = 0; j < pp.length; j++) {
                subs[ss[i + j] - 'a']++;
            }
            if (Arrays.equals(words, subs)) {
                res.add(i);
            }
            i++;
        }
        return res;
    }

    /**
     * 标准答案：优化前的代码更像是一种暴力搜索，优化后的代码如下，具体思路为：cnt为统计每个字母的频率，维护一个动态窗口，这个窗口满足，如果里面有一个p中没有的字母，
     * 那么窗口左边右移，直到不存在，如果不存在那么说明，这个窗口有可能满足条件，那么窗口右边继续移动，直到窗口的长度和p的长度一致了，那么说明慢许条件
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]--; // 右端点字母进入窗口
            while (cnt[c] < 0) { // 字母 c 太多了
                cnt[s.charAt(left) - 'a']++; // 左端点字母离开窗口
                left++;
            }
            if (right - left + 1 == p.length()) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        _009_FindAnagrams findAnagrams = new _009_FindAnagrams();
        System.out.println(Arrays.toString(findAnagrams.findAnagrams("abab", "ab").toArray()));
    }
}

