package hot100._01_hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。  你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。  你可以按任意顺序返回答案。
 * <p>
 * Last Modified:
 * @date 2024/12/10 10:02
 */
public class _001_TwoNumSum {
    /*
    思路1：可以用hash表存储，遍历第i个元素时，需要寻找target-num[i]元素存不存在，可以通过hash表快速找到，遍历的时候可以优化一下：
           先在map中找target-num[i]存不存在，不存在将i个元素加入到map中，后面可能会有与其配对的
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        _001_TwoNumSum twoNumSum = new _001_TwoNumSum();
        System.out.println(Arrays.toString(twoNumSum.twoSum(new int[]{1, 2, 3, 4, 5}, 9)));
    }
}

