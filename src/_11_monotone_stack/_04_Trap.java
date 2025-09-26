package _11_monotone_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * Last Modified:
 * @date 2024/12/3 9:32
 */
public class _04_Trap {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.peek() != null && height[stack.peek()] < height[i]) {
                //stack.peek是选中的柱子，height[stack.peek]是右边比他高的第一个柱子，height[stack.倒数第二个]是左边比他高的柱子
                int rightMax = height[stack.pollFirst()];
                //存在被夹住的情况
                if (stack.peek() != null) {
                    //接到雨水相当于用一个柱子填充进去了，然后找到两个高柱子，底都是平的。如果这样思考，相对于力扣的算法，不需要考虑遇到相同柱子的问题
                    res += (Math.min(height[stack.peek()], height[i]) - rightMax) * (i - stack.peek()-1);
                }
                i--;
            }  else {
                stack.offerFirst(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _04_Trap trap = new _04_Trap();
        System.out.println(trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

