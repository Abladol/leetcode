package hot100._05_ordinary_array;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:
 * 思路：
 * 1. 使用单指针和临时变量（缓存）实现原地旋转，不需要额外数组。
 * 2. 使用两级缓存：
 * - 一级缓存保存当前元素的值，以便在后续为其寻找新位置时使用。
 * - 二级缓存保存目标位置的值，防止原始数据被覆盖。
 * 3. 通过循环依次将每个元素移动到目标位置，计算新索引为 `(index + k) % size`。
 * 局限性：
 * 1. 当数组长度和步长 k 的最大公约数（GCD）不为 1 时，会出现“循环链”，导致部分元素未被覆盖，最终结果错误。
 * 2. 缺少循环链检测逻辑，无法保证所有元素都能正确移动到新位置。
 * <p>
 * Last Modified:
 * @date 2025/1/3 19:07
 */
public class _015_Rotate {
    /*
    最简单的方法自然就是构造新数组，过于简单
    原地旋转，
     */
    public void rotate(int[] nums, int k) {
        int index = 0;
        int temp0;
        int temp1 = nums[0];
        int size = nums.length;
        int flag = 0;
        for (int i = 0; i < size; i++) {
            //解决循环的问题，通过flag判断是否回到了起点，如果回到起点，继续下一个数开始循环
            if (i > 0 && index == flag) {
                index++;
                flag++;
                temp1 = nums[index % size];
            }
            //一级缓存存的是当前被替换的值，也就是下一次为这个值找新位置
            temp0 = nums[(index + k) % size];
            //二级缓存存的是新位置应该存放的数
            nums[(index + k) % size] = temp1;
            temp1 = temp0;
            index = (index + k) % size;
        }
        System.out.println(Arrays.toString(nums));
    }


    /*
    官方思路：这个思路更加巧妙，既然移动k个，那就说明，最后k个元素要在前面，剩余的n-k个元素移到后面去了，那么先将数组反转，就满足刚刚条件了，只是顺序是反的，
            所以我们再分别反转两次即可
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        _015_Rotate rotate = new _015_Rotate();
        rotate.rotate(new int[]{1, 2, 3, 4}, 2);
    }
}

