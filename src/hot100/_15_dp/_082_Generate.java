package hot100._15_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。  在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * Last Modified:
 * @date 2025/2/17 20:23
 */
public class _082_Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(new ArrayList<>(temp));
        for (int i = 1; i < numRows; i++) {
            int[] dp = new int[i + 1];
            dp[0] = 1;
            //上一层
            int[] pre = temp.stream().mapToInt(Integer::intValue).toArray(); //i个元素
            for (int j = 1; j < i; j++) {
                dp[j] = pre[j - 1] + pre[j];
            }
            dp[i] = 1;
            temp = Arrays.stream(dp).boxed().toList();
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    /*
    官方答案：思路是一样的，简化了一点，没有中间数组dp，因为可以直接从list中获得
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            //这里处理的是i+1行，共有i+1个数
            for (int j = 0; j <= i; j++) {
                //第一个数和最后一个数都是1
                if (j==0||j==i){
                    temp.add(1);
                }else {
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        _082_Generate generate = new _082_Generate();
        List<List<Integer>> lists = generate.generate2(3);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

