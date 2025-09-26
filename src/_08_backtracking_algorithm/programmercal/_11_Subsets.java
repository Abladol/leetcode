package _08_backtracking_algorithm.programmercal;

import java.util.*;

public class _11_Subsets {
    private List<Integer> temp = new LinkedList<>();

    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(Collections.emptyList());
        backTrace(nums,0);
        return res;

    }

    void backTrace(int[] nums,int startIndex){
        //回溯终止条件
        if(startIndex==nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            //添加全部节点
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backTrace(nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _11_Subsets subsets = new _11_Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        for (List<Integer> list:subsets1 ) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
}
