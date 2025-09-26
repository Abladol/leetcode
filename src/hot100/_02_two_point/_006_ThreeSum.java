package hot100._02_two_point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。  注意：答案中不可以包含重复的三元组。
 * <p>
 * Last Modified:
 * @date 2024/12/15 14:03
 */
public class _006_ThreeSum {
    /*
    现将数组排序，使用双指针
    关键在于去重，去重首先对外部去重，比如-1，-1，-1，-1，2，2，2
    第一层for循环遍历第一个-1，获得结果，但是下一个遍历第二个-1，实际上答案是一样的，所以第一层for循环遍历要跳过第一个-1，至于跳到哪儿为止
        我们可以先处理第一个-1，如果我们下次再处理还是-1，跳过，就是先处理后去重
    对于内部去重，比较简单，如果移动后数据一样就没有必要移动，继续跳

     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left;
        int right;
        for (int i = 0; i < nums.length; i++) {
            //外部去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            //使用双指针
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                //相等的时候，要进行内部去重，如果左指针移动后数值一样就要继续移动，直到移动到不一样数，右指针也一样
                //不相等的时候是需要去重的
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _006_ThreeSum threeSum = new _006_ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{0, -1, 0, 1, 0, 2});
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

