package hot100._02_two_point;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * Last Modified:
 * @date 2024/12/18 13:36
 */
public class _007_TrapRain {
    /*
    思路：我们可以按照每一列来接雨水，如果想知道这一列最多能接多少雨水，那么就需要知道他左右两边最先遇到的两个最高的高度，短板效应，所以想到单调栈来实现
     */
    public int trap(int[] height) {
        //需要寻找最大最近的元素，栈内元素是单减的
        Deque<Integer> stack = new LinkedList<>();
        // 用于存储接到的雨水总量
        int maxVolume = 0;

        for (int i = 0; i < height.length; i++) {
            // 如果栈不为空且当前元素大于栈顶元素，说明找到了右边比栈顶更高的元素
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int x = stack.pop();
                if (!stack.isEmpty()) {
                    // 栈底的元素是当前x的左边第一个更高的柱子
                    // 当前元素i与栈顶元素之间的距离
                    int distance = i - stack.peek() - 1;
                    int boundedHeight = Math.min(height[stack.peek()], height[i]) - height[x];
                    maxVolume += distance * boundedHeight;
                }
            }
            // 将当前元素的索引压入栈中
            stack.push(i);
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        _007_TrapRain trapRain = new _007_TrapRain();
        System.out.println(trapRain.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

