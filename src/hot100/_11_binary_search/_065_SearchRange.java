package hot100._11_binary_search;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。  你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * Last Modified:
 * @date 2025/2/17 16:34
 */
public class _065_SearchRange {
    /*
    我的思路：时间复杂度为 O(log n)适合使用二分查找法，先确认是否存在这个数，没有直接返回0，存在然后向两边展开，求的范围
     */
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                //找到了，开始确认范围
                l = m;
                r = m;
                boolean lflag = false;
                boolean rflag = false;
                while (!(lflag && rflag)) {
                    if (!lflag) l--;
                    if (!rflag) r++;
                    if (l < 0 || nums[l] != target) {
                        lflag = true;
                        l++;
                    }
                    if (r == nums.length || nums[r] != target) {
                        rflag = true;
                        r--;
                    }
                }
                return new int[]{l, r};
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return new int[]{-1, -1};
    }

    /*
    官方答案：上述确实可以通过，但是时间复杂度并不满足要求，原因在于找到目标后，向两边暴力搜索，官方则是继续二分查找
    其实我们要找的就是数组中「第一个等于 target 的位置」（记为 leftIdx）和「第一个大于 target 的位置减一」（记为 rightIdx）。
    二分查找中，寻找 leftIdx 即为在数组中寻找第一个大于等于 target 的下标，寻找 rightIdx 即为在数组中寻找第一个大于 target 的下标，然后将下标减一。
    两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower) 表示在 nums 数组中二分查找 target 的位置，如果 lower 为 true，
    则查找第一个大于等于 target 的下标，否则查找第一个大于 target 的下标。
     */
    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _065_SearchRange searchRange = new _065_SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5}, 5)));
    }
}

