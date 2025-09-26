package hot100._05_ordinary_array;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: (困难题)给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。  请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * Last Modified:
 * @date 2025/1/5 15:02
 */
public class _017_FirstMissingPositive {
    /*
    本题关键在于寻找1到数组长度的之间的值依次在不在数组里面，这一点先要理解
    完全没思路，gpt给的思路很巧妙：把原始的数组当做哈希表来使用,将数组中的正数放到它“应在的位置”，即值为 x 的正数放到索引 x-1 的位置。通过一次遍历和原地交换，可以完成这个操作。
    然后再遍历一次数组，找到第一个位置不满足 nums[i] == i+1 的位置即可。
     */
    public int firstMissingPositive(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //不在0到数组长度的范围是可以直接跳过的，此外如果位置本来就正确也可以跳过，还有如果这个数如果他正确的位置上已经放上了正确的数也就是这两个数相等也不需要交换
            if (nums[i] >= nums.length || nums[i] <= 0 || nums[i]==i+1 || nums[nums[i]-1]==nums[i]) {
                continue;
            } else {
                j = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = j;
                i--;
            }
        }
        //找到答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        _017_FirstMissingPositive firstMissingPositive = new _017_FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1,1}));
    }
}

