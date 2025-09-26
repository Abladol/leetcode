package hot100._15_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * Last Modified:
 * @date 2025/2/24 20:13
 */
public class _086_WordBreak {
    /*
    我的思路：动态规划,dp[i]=dp[j] && check(s[j..i−1]),其中 check(s[j..i−1]) 表示子串 s[j..i−1] 是否出现在字典中,第二层遍历应该从后向前
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                if (dp[j - 1] == true && set.contains(s.substring(j - 1, i))) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        _086_WordBreak wordBreak = new _086_WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak.wordBreak("applepenapple", wordDict));
    }
}

