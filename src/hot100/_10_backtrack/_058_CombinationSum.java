package hot100._10_backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。  candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * Last Modified:
 * @date 2025/2/19 19:25
 */
public class _058_CombinationSum {
    /*
    我的思路：如果需要判断组合的数量，我觉得这个用动态规划的完全背包可以解决，组合问题，先遍历物品，再遍历背包
    答案需要输出结果，需要使用回溯
     */
    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        retrace(candidates, target,0);
        return res;
    }

    public void retrace(int[] candidates, int target, int start) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        //外层遍历
        for (int i = start; i < candidates.length; i++) {
            //纵向遍历,起点可以一直从i开始，因为这是组合问题，不能重复，但是当我的结果retrun一次，j应该要从下一个开始遍历了
                temp.add(candidates[i]);
                sum += candidates[i];
                retrace(candidates, target,i);
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        _058_CombinationSum combinationSum = new _058_CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 5}, 1);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

