package _11_monotone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，
 * 请在该位置用 0 来代替。  例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * Last Modified:
 * @date 2024/11/29 9:33
 */
public class _01_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //如果当前的大于栈顶元素，说明找到了
            if(stack.peek()!=null && temperatures[i]>temperatures[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pollFirst();
                i--;
            }else {
                stack.offerFirst(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _01_DailyTemperatures dailyTemperatures = new _01_DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

