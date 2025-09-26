package hot100._01_hash;

import java.util.HashSet;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * Last Modified:
 * @date 2024/12/10 12:42
 */
public class _003_LongestConsecutive {
    /*
    思路：既然要计算一个连续序列的最大长度，那么得从头开始数，所以可以先找到头，判断头的方法：前一个数没有，判断尾的方法：下一个数没有
    因此，可以使用set来包含所有的数
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //这里面的max应该是0，会存在nums为空的情况
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        //可以优化：原先是遍历mums数组，但是没有必要，因为里面有重复数据，所以可以直接遍历set
        for (int num : set) {
            int temp = 1;
            //判断是不是头，只从头开始计数
            if (set.contains(num - 1)) {
                continue;
            }
            //判断是不是尾
            while (set.contains(num + temp)) {
                temp++;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _003_LongestConsecutive longestConsecutive = new _003_LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(new int[]{}));
    }
}

