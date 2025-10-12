package review_code;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * Last Modified:
 * @date 2025/10/12 16:02
 */
public class _300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        _300_LengthOfLIS lengthOfLIS = new _300_LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{2,2,2,2}));
    }
}

