package _10_dynamic_programming.programmercal;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class _13_CanPartition {
    /**
     * 背包问题，一般的空间装满一半的价值
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false;
        }
        int size = Arrays.stream(nums).sum() / 2;
        //dp：横的：物品，纵轴：背包体积就是size
        int[][] dp = new int[nums.length][size + 1];

        //初始化，放第0个物品
        for (int i = 1; i < size + 1; i++) {
            if (nums[0] <= i) {
                dp[0][i] = nums[0];
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < size + 1; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][size] == size) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
}
