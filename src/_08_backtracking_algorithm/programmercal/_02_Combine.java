package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 *
 * 回溯算法理解为
 */
public class _02_Combine {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k, 1);
        return res;
    }

    public void backTrack(int n, int k, int startIndex) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;

        }
        for (int i = startIndex; i <= n; i++) {
            temp.add(i);
            backTrack(n, k, i + 1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _02_Combine test = new _02_Combine();
        System.out.println(Arrays.toString(test.combine(5, 3).toArray()));

    }
}
