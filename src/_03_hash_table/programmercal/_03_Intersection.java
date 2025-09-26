package _03_hash_table.programmercal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class _03_Intersection {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 3, 4};
        int[] num2 = new int[]{1, 2, 3, 2, 4, 5, 6};

        System.out.println(Arrays.toString(intersection(num1, num2)));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }
        for (int n :
                nums2) {
            if (num1Set.contains(n)) {
                result.add(n);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();


    }
}
