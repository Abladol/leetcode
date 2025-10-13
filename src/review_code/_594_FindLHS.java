package review_code;

import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 最长和谐子序列,和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * Last Modified:
 * @date 2025/10/13 20:11
 */
public class _594_FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (Integer i : map.keySet()) {
            if (map.containsKey(i + 1)) {
                max = Math.max(max, map.get(i) + map.getOrDefault(i + 1, 0));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _594_FindLHS findLHS = new _594_FindLHS();
        System.out.println(findLHS.findLHS(new int[]{1, 1, 1, 1}));

    }
}

