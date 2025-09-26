package _11_monotone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素
 * 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * Last Modified:
 * @date 2024/12/3 8:46
 */
public class _03_NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (stack.peek() != null && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.peek()] = nums[i % nums.length];
                stack.pollFirst();
                i--;
            } else {
                stack.offerFirst(i % nums.length);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _03_NextGreaterElements2 nextGreaterElements2 = new _03_NextGreaterElements2();
        System.out.println(Arrays.toString(nextGreaterElements2.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}

