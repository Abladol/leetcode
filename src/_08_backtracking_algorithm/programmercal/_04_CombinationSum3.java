package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class _04_CombinationSum3 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    private  int sum =0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrace(k,n,1);
        return res;
    }


    //todo 可以进行剪枝操作，当和大于n的时候，后面的遍历无意义，可以将sum作为回溯函数的参数之一，在回溯开始进行判断
    public void backTrace(int k, int n, int startIndex) {
        //回溯终止条件
        if (temp.size() == k) {
            for (Integer x : temp) {
                sum = sum + x;
            }
            if (sum == n) {
                sum = 0;
                res.add(new ArrayList<>(temp));
                return;
            }
            return;
        }

        //回溯
        for (int i = startIndex; i < 10; i++) {
            temp.add(i);
            backTrace(k,n,i+1);
            //退回上一步
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _04_CombinationSum3 combinationSum3 = new _04_CombinationSum3();
        System.out.println(Arrays.toString(combinationSum3.combinationSum3(3, 7).toArray()));
    }
}
