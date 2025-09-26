package _08_backtracking_algorithm.programmercal;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class _13_SubsetsWithDup {
    private List<Integer> temp = new ArrayList<>();

    private List<List<Integer>> result = new ArrayList<>();

    private Integer removeNum;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(Collections.emptyList());
        //回溯算法去重必须要先排序
        Arrays.sort(nums);
        backTrace(nums, 0);
        return result;
    }

    public void backTrace(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            //回溯移除的元素，和现在要添加的元素一样就没必要继续下去了。
            if (removeNum!=null && nums[i] == removeNum) {
                continue;
            }
            temp.add(nums[i]);
            backTrace(nums, i + 1);
            result.add(new ArrayList<Integer>(temp));
            removeNum = temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        _13_SubsetsWithDup subsetsWithDup = new _13_SubsetsWithDup();
        List<List<Integer>> result = subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> res : result) {
            System.out.println(Arrays.toString(res.toArray()));
        }

    }
}
