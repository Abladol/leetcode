package _09_greedy_algorithm.programmercal;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class _09_LargestSumAfterKNegations {
    //标准答案
    public int largestSumAfterKNegations0(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] >= 0 || i == nums.length - 1) {
                Arrays.sort(nums);
                nums[0] = k % 2 == 0 ? nums[0] : -nums[0];
                break;
            }
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        return Arrays.stream(nums).sum();
    }



    public static void main(String[] args) {
        _09_LargestSumAfterKNegations largestSumAfterKNegations = new _09_LargestSumAfterKNegations();
        System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
    }
}
