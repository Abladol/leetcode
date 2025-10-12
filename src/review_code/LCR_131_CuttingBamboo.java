package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。
 * <p>
 * Last Modified:
 * @date 2025/10/12 14:07
 */
public class LCR_131_CuttingBamboo {
    public int cuttingBamboo(int bamboo_len) {
        int[][] dp = new int[bamboo_len - 1][bamboo_len + 1];
        for (int i = 0; i < bamboo_len + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < bamboo_len - 1; i++) {
            for (int j = 0; j <= bamboo_len; j++) {
                if (j >= i + 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i - 1] * (i + 1));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[bamboo_len - 2][bamboo_len];
    }

    public static void main(String[] args) {
        LCR_131_CuttingBamboo lcr131CuttingBamboo = new LCR_131_CuttingBamboo();
        System.out.println(lcr131CuttingBamboo.cuttingBamboo(3));
    }
}

