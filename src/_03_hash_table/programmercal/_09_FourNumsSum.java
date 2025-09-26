package _03_hash_table.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _09_FourNumsSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(nums, -294967296));


    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //优化部分：i其实只要判断到倒数第四个就可以了
        for (int i = 0; i < nums.length - 3; i++) {
            //去重，去重的思路是这一次的数据和上一次的数据相同则是重复，第一个判断条件是确保不会超出数组边界，如果采用这一次的数据和下一次的数据相同那么是错误的
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j:
            //优化，j只要判断到倒数第三个就行
            for (int j = i + 1; j < nums.length - 2; j++) {
//去重，去重的思路是这一次的数据和上一次的数据相同则是重复，第一个判断条件是隔绝第一次i和j的数据。
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int slow = j + 1;
                int fast = nums.length - 1;
                while (slow < fast) {
//用long类型，防止溢出，另外要进项强转告诉编译器这是long类型，
                    long sum = (long) nums[i] + nums[j] + nums[slow] + nums[fast];
                    // 易错点：当满足条件后还可以继续找
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[slow], nums[fast]));
                        while (slow < fast && nums[slow] == nums[slow + 1]) {
                            slow++;
                        }
                        while (slow < fast && nums[fast] == nums[fast - 1]) {
                            fast--;
                        }
                        slow++;
                        continue;
                    } else if (sum < target) {
                        slow++;
                    } else {
                        fast--;
                    }

                }

            }

        }
        return ans;
    }
}
