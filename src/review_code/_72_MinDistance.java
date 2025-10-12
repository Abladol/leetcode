package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * 编辑距离
 * Description: 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：  插入一个字符 删除一个字符 替换一个字符
 * <p>
 * Last Modified:
 * @date 2025/10/12 18:49
 */
public class _72_MinDistance {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        for (int i = 0; i < ch1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < ch2.length + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < ch1.length + 1; i++) {
            for (int j = 1; j < ch2.length + 1; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    //相当于所有的匹配都是匹配最后一个字母
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        _72_MinDistance minDistance = new _72_MinDistance();
        System.out.println(minDistance.minDistance("a", "aa"));

    }
}

