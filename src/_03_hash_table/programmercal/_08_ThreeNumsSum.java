package _03_hash_table.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class _08_ThreeNumsSum {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();

        int[] nums = new int[]{0,0,0,0};
        res = threeSum(nums);
        for (List r : threeSum(nums)) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //有一种特殊情况三个0
//        if(nums[nums.length-1]==0 &&nums[nums.length-2]==0 &&nums[nums.length-3]==0 ){res.add(Arrays.asList(0,0,0));}
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            //i去除重复
            if(i-1>=0 && nums[i]==nums[i-1]){continue;}


            while (left < right) {


                //去除重复元素
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left+1]==nums[left] && left+1!=right){left++;continue;}
                    while (nums[right-1]==nums[right] && left+1!=right){right--;continue;}
                    left++;
//                    break;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return res;
    }

    /**
     * 改进代码，增加剪枝操作，就是判断当第一个nums[i]大于0的时候，直接返回结果，因为后面的数都是正数，不可能和为0
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
