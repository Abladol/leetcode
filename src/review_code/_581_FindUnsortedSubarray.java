package review_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 最短无序连续子数组,给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * Last Modified:
 * @date 2025/10/12 19:12
 */
public class _581_FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                do {
                    int top = nums[stack.peek()];
                    if (top <= nums[i]) {
                        stack.push(i);
                        break;
                    } else {
                        start = Math.min(start, stack.pop());
                    }
                } while (!stack.isEmpty());//这样保证stack里面是有序的，栈顶的第二个元素的下一个开始就是需要重新排序的
            } else {
                stack.push(i);
            }
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                do {
                    int top = nums[stack.peek()];
                    if (top >= nums[i]) {
                        stack.push(i);
                        break;
                    } else {
                        end = Math.max(end, stack.pop());
                    }
                } while (!stack.isEmpty());//这样保证stack里面是有序的，栈顶的第二个元素的下一个开始就是需要重新排序的终点
            } else {
                stack.push(i);
            }
        }

        return end >= start ? end - start +1  : 0;
    }

    public static void main(String[] args) {
        _581_FindUnsortedSubarray findUnsortedSubarray = new _581_FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(new int[]{3,2}));

    }
}

