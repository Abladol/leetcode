package review_code;

import example.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 组合总和 II,给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。  注意：解集不能包含重复的组合。
 * <p>
 * Last Modified:
 * @date 2025/10/13 21:00
 */
public class _40_CombinationSum2 {
    private List<List<Integer>> res = new ArrayList<>();
    private int sum = 0;
    private List<Integer> temp = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        retrace(candidates, target, 0);
        return res;
    }

    public void retrace(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && candidates[i] == candidates[i - 1])) {
                continue;
            }
            visited[i] = true;
            sum += candidates[i];
            temp.add(candidates[i]);
            retrace(candidates, target, i + 1);
            visited[i] = false;
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        _40_CombinationSum2 combinationSum2 = new _40_CombinationSum2();
        List<List<Integer>> res = combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}

