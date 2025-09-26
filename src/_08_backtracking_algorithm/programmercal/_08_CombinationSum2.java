package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class _08_CombinationSum2 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backTrace(candidates, target,0);
        return res;
    }

    public void backTrace(int[] candidates, int target,int startIndex) {
        //回溯终止条件
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum>target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            backTrace(candidates, target,i+1);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        _08_CombinationSum2 combinationSum2 =new _08_CombinationSum2();
        System.out.println(Arrays.toString(combinationSum2.combinationSum2(new int[]{1, 2, 3, 4,4}, 8).toArray()));
    }
}
