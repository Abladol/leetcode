package _03_hash_table.programmercal;

import java.util.HashMap;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class _06_FourNumsCount {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }


    /**
     * 本题解题步骤：
     * 首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
     * 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
     * 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
     * 最后返回统计值 count 就可以了
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                if (map.get(-n3 - n4) != null) count += map.get(-n3 - n4);
            }
        }
        return count;
    }
}
