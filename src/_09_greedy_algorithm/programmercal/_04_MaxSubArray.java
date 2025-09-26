package _09_greedy_algorithm.programmercal;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组
 * 是数组中的一个连续部分。
 */
public class _04_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int temp = 0;

        for (int num : nums) {
            temp += num;
            if (temp < 0) {
                result = Math.max(temp, result);
                temp = 0;
            } else {
                result = Math.max(temp, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _04_MaxSubArray maxSubArray = new _04_MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-100,-10,-2}));
    }
}
