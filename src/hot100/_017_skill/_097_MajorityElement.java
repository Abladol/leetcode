package hot100._017_skill;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * Last Modified:
 * @date 2025/3/12 20:38
 */
public class _097_MajorityElement {
    /*
    我的思路：暴力手法：使用map记录次数
    官方思路：有很多解法，选择其中一个比较简单的，因为他超过一半，那么数组中的中位数一定是那个数，所以可以使用排序
     */
    public int majorityElement(int[] nums) {
        int[] sorted = sort(nums, 0, nums.length-1);
//        int[] xx= new int[]{2,4,3,2,43,234,543,23,132,23,45,3,-2,-3};
//        System.out.println(Arrays.toString(sort(xx, 0, xx.length-1)));
        return sorted[sorted.length/2];
    }

    public int[] sort(int[] nums, int l, int r) {
        if(l>=r){
            return new int[]{nums[l]};
        }
        int m = (l + r) / 2;
        int[] left = sort(nums, l, m);
        int[] right = sort(nums, m+1, r);
        return merge(left, right);
    }

    public int[] merge(int[] l, int[] r) {
        int[] res = new int[l.length + r.length];
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < res.length; i++) {
            boolean isl = lIndex < l.length;
            boolean isr = rIndex < r.length;
            if (isl && isr && l[lIndex] < r[rIndex]) {
                res[i] = l[lIndex];
                lIndex++;
            } else if (isl && isr && l[lIndex] >= r[rIndex]) {
                res[i] = r[rIndex];
                rIndex++;
            } else if (!isl) {
                res[i] = r[rIndex];
                rIndex++;
            } else {
                res[i] = l[lIndex];
                lIndex++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _097_MajorityElement majorityElement = new _097_MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}

