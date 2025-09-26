package hot100._02_two_point;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * Last Modified:
 * @date 2024/12/11 14:44
 */
public class _004_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pre = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            //pre指针主要指向0的位置，cur指向非零的位置
            if(nums[cur]!=0 && nums[pre]!=0){
                pre++;
                continue;
            }else if(nums[pre]==0 && nums[cur]!=0){
                nums[pre]=nums[cur];
                nums[cur]=0;
                pre++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    代码可以优化，不用考虑左右指针都不为0的情况，只考虑右指针，为0就直接下一个，不为0就执行交换，交换后左右指针都继续下一个
     */
    public void moveZeroes2(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        _004_MoveZeroes moveZeroes = new _004_MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,2,0,4,0,0,0,3,4,0});
    }
}

