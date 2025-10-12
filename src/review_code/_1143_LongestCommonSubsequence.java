package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * 最长公共子序列
 * Description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。
 * 如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * Last Modified:
 * @date 2025/10/12 18:05
 */
public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length+1][ch2.length+1];
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        _1143_LongestCommonSubsequence longestCommonSubsequence = new _1143_LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));

    }
}

