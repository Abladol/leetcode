package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */
public class _14_FindSubsequences {
    private List<Integer> temp = new ArrayList<>();

    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums, 0);
        return result;
    }

    public void backTrace(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        //这里面每个usedNum都是不一样的，只会在自己调用的作用域中
        HashSet<Integer> usedNum = new HashSet<>();
        //for循环都是同一层的
        for (int i = startIndex; i < nums.length; i++) {
            if (!temp.isEmpty() && temp.get(temp.size() - 1) > nums[i] || usedNum.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            usedNum.add(nums[i]);
            if (temp.size() >= 2) {
                result.add(new ArrayList<>(temp));
            }
            backTrace(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        _14_FindSubsequences findSubsequences = new _14_FindSubsequences();
        List<List<Integer>> findSubsequencesSubsequences = findSubsequences.findSubsequences(new int[]{2, 7, 6, 7});
        for (List<?> sub : findSubsequencesSubsequences) {
            System.out.println(Arrays.toString(sub.toArray()));
        }
    }
}
