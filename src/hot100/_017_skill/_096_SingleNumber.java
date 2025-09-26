package hot100._017_skill;

import java.util.HashSet;
import java.util.Set;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * Last Modified:
 * @date 2025/3/12 20:31
 */
public class _096_SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean add = set.add(num);
            if(!add){
                set.remove(num);
            }
        }
        return (int) set.toArray()[0];
    }

    /*
    官方思路：这是一个技巧题：两个相同的数异或等于0，并且异或满足交换律
     */
    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        _096_SingleNumber singleNumber =new _096_SingleNumber();
        System.out.println(singleNumber.singleNumber2(new int[]{4, 1, 2, 1, 2}));
    }
}

