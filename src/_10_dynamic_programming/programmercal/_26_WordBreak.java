package _10_dynamic_programming.programmercal;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author AiJun
 * @version 1.0
 * @date 2024/10/31 13:05
 */
public class _26_WordBreak {
    /**
     * 完全背包，排列问题
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0]=true;
        //排列问题，现在遍历背包，再遍历物品
        for (int i = 0; i < s.length() + 1; i++) {
            //遍历物品
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                //能不能装下，装下后，这一段是不是s对应位置的一段，如果是，继续判断前面几段能否拼成
                if (word.length() <= i && word.equals(s.substring(i-word.length(),i)) && dp[i - word.length()]) {
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("app");
        wordDict.add("ap");
        wordDict.add("pen");
        wordDict.add("n");
        System.out.println(wordBreak("appen", wordDict));
    }
}
