package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出： [[1,1,2], [1,2,1], [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class _16_PermuteUnique {
    private List<Integer> temp = new ArrayList<>();

    private List<List<Integer>> result = new ArrayList<>();

    private int[] usedIndex;

    public List<List<Integer>> permuteUnique(int[] nums) {
        usedIndex = new int[nums.length];
        Arrays.sort(nums);
        backtrace(nums);
        return result;
    }

    //注意：去重一定要对元素排序
    public void backtrace(int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            //usedIndex[i-1] == 0这是限制判断的数是在一层，没有被使用过
            if (i >= 1 && usedIndex[i-1] == 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (usedIndex[i] == 1) {
                continue;
            }
            temp.add(nums[i]);
            usedIndex[i] = 1;
            backtrace(nums);
            temp.remove(temp.size() - 1);
            usedIndex[i] = 0;
        }
    }

    public static void main(String[] args) {
        _16_PermuteUnique permuteUnique = new _16_PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(new int[]{1, 1, 1,2});
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
