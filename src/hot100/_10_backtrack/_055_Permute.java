package hot100._10_backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * Last Modified:
 * @date 2025/2/16 15:38
 */
public class _055_Permute {
    /*
    我的思路：使用回溯算法
     */
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        retrace(nums);
        return res;
    }

    public void retrace(int[] nums) {
        //回溯终止条件，和二叉树一样到底了就结束
        if (temp.size() == nums.length) {
            //一定要new一个，因为temp始终在变
            res.add(new ArrayList<>(temp));
            return;
        }
        //回溯开始,横向方向遍历
        for (int i = 0; i < nums.length; i++) {
            //进入回溯一开始，为了避免重复,就是temp已经存下这个数了说明之前已近遍历过这个数了
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            //进去回溯
            retrace(nums);
            //回溯结束
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _055_Permute permute = new _055_Permute();
        List<List<Integer>> res = permute.permute(new int[]{1, 2, 3});
        for (List<Integer> x : res) {
            System.out.println(Arrays.toString(x.toArray()));
        }
    }
}

