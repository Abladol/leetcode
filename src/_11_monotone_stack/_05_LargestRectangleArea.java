package _11_monotone_stack;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。  求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * Last Modified:
 * @date 2024/12/5 8:56
 */
public class _05_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] newHeights = new int[heights.length+2];
        newHeights[0]=0;
        newHeights[newHeights.length-1]=0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeights.length; i++) {
            if(stack.peek()!=null && newHeights[i]<newHeights[stack.peek()]){
                int cur = stack.pollFirst();
                // 第i个柱子左边有比他矮的，计算面积
                if(stack.peek()!=null){
                    res= Math.max((i-stack.peek()-1)*newHeights[cur],res);
                }
                i--;
            }else {
                stack.offerFirst(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _05_LargestRectangleArea largestRectangleArea = new _05_LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }




}

