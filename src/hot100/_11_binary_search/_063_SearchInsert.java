package hot100._11_binary_search;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * Last Modified:
 * @date 2025/2/16 19:29
 */
public class _063_SearchInsert {
    /*
    我的思路：要求了时间复杂度，那么就要使用二分查找
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        //这个判断一定是=，因为如果不是等于会出现一个情况，那就是l和r重合，这个时候需要进行判断，target比l大那就是l+1，比l小那就是l
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        _063_SearchInsert searchInsert = new _063_SearchInsert();
        System.out.println(searchInsert.searchInsert(new int[]{1, 3,5,7}, 2));
    }


}

