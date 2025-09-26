package hot100._04_substring;

import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * Last Modified:
 * @date 2024/12/19 10:10
 */
public class _010_SubarraySum {
    /*
        标准答案：前缀法，nums可以分为三段abc，b为满足条件的子数组，a和c分别为前缀后后缀，其中b=k，在我们对数组遍历的时候是可以依次求取a+b的值的，而历史的a+b的值
                可以看作为a，所以这两个值是知道的，例如当我们遍历第i个元素的时候，可以求出a+b的值，如果希望知道是否存在子数组满足条件就需要知道前缀表中是否有和为a+b-k的
                值，如果有则满足条件
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        //存储前缀表
        HashMap<Integer, Integer> map = new HashMap<>();
        //最开始的前缀就是0
        map.put(0,1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            //map中key的前缀表的值，value是前缀表的格式
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
        }
        return res;
    }

    /*
    个人思路：错误思路：这道题有一个条件，就是对子数组的定义，那么说明是不可以对原数组进行排序的，这个题目很像滑动窗口
    维护一个滑动窗口，如果和大了，窗口缩小一点，如果和小了，窗口大一点
    这个思路无法解决这个问题的，因为会存在一个问题，假设期望的和为0，数组为1,-1,1，当使用滑动窗口的时候，导致逻辑会完全错误
     */
    public int subarraySum2(int[] nums, int k) {
        int i = 0;
        //窗口的和
        int sum = 0;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum == k) {
                res++;
            } else if (i < j && sum > k) {
                i++;
                sum -= nums[i - 1];
                sum -= nums[j];
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _010_SubarraySum subarraySum = new _010_SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1,-1,1}, 0));
    }
}

