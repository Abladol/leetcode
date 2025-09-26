package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * #
 */
public class _15_Permute {
    private List<Integer> temp = new ArrayList<>();

    private List<List<Integer>> result = new ArrayList<>();

    int[] bit;



    public List<List<Integer>> permute(int[] nums) {
        bit = new int[nums.length];
        backeTrace(nums);
        return result;
    }

    public void backeTrace(int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        //每一层不能有同一个数据
        for (int i = 0; i < nums.length; i++) {
            if (bit[i] == 1) {
                continue;
            }
            temp.add(nums[i]);
            bit[i] = 1;
            backeTrace(nums);
            temp.remove(temp.size() - 1);
            //注意，remove的就是上一步添加的，自然就是num[i]
            bit[i] = 0;
        }
    }

    public static void main(String[] args) {
        _15_Permute permute = new _15_Permute();
        List<List<Integer>> permute1 = permute.permute(new int[]{1, 1, 3});
        for (List<Integer> list : permute1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
