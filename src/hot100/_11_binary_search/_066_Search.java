package hot100._11_binary_search;

import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。  给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * Last Modified:
 * @date 2025/3/1 19:45
 */
public class _066_Search {
    /*
    我的思路：二分查找，中间指针将其一分为二，那么要么左边有序有么右边有序，这个时候可以直接在有序的里面判断是否在那边
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            //判断中间指针是否在有序数列中，就是在左边不
            boolean isleft = nums[l] <= nums[m] ? true : false;
            if (nums[m] == target) {
                return m;
            } else if (isleft) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int target = sc.nextInt();

        _066_Search search = new _066_Search();
        System.out.println(search.search(nums, target));

    }
}

