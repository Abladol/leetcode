package _10_dynamic_programming.programmercal;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * @author AiJun
 * @date 2024/10/29 13:43
 * @version 1.0
 */
public class _17_FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        //m和n就是两个背包的容积
        int[][] dp = new int[m + 1][n + 1];
        //两个重量
        int zero = 0;
        int one = 0;
        //初始化
        //遍历物品
        for (String s : strs) {
            //找到物品的重量，有几个0和几个1
            byte[] bs = s.getBytes();
            for (byte b : bs) {
                if (b == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            //递推背包m
            for (int i = m; i >= 0; i--) {
                //递推背包n ，可以放1
                for (int j = n; j >= 0; j--) {
                    //能放下物品
                    if (zero <= i && one <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
            }
            zero = 0;
            one = 0;
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"11", "01","0","1"}, 1, 3));
    }
}
