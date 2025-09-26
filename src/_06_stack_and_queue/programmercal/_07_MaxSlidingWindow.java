package _06_stack_and_queue.programmercal;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class _07_MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> stack = new LinkedList<>();
        int resLength = nums.length - k;
        int[] res = new int[nums.length - k + 1];
        //填充初始队列，关键一步
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()]<=nums[i]){
                stack.pollLast();
            }
            stack.offer(i);
        }
        res[0] = nums[stack.peek()];
        //开始向后遍历
        for (int i = 0; i < resLength; i++) {
            if(!stack.isEmpty() && i>= stack.peekFirst()){
                stack.pollFirst();
            }
            while (!stack.isEmpty() && nums[i+k]>= nums[stack.peekLast()]){
                stack.pollLast();
            }
            stack.offer(i+k);
            res[i+1] = nums[stack.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(a, 3)));

    }


}
