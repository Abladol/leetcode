package hot100._10_backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的 子集 （幂集）。  解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * Last Modified:
 * @date 2025/2/16 16:08
 */
public class _056_Subsets {
    /*
    我的思路：回溯算法，选完数后，那个就是子集，但是要注意，每次选数不用从0开始遍历，就是纵向遍历的时候直接从上一层的序号开始遍历
     */
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        retrace(nums,0);
        res.add(Collections.EMPTY_LIST);
        return res;
    }

    public void retrace(int[] nums,int i){
        //回溯结束
        if(i==nums.length){
            return;
        }
        //横向遍历开始
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            res.add(new ArrayList<>(temp));
            retrace(nums,j+1);
            //回溯
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _056_Subsets subsets = new _056_Subsets();
        List<List<Integer>> res = subsets.subsets(new int[]{1, 2, 3});
        for (List<Integer> x : res) {
            System.out.println(Arrays.toString(x.toArray()));
        }
    }
}

