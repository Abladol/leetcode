package _09_greedy_algorithm.programmercal;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class _12_Candy {
    /*
    思路：先贪右边比左边大，那么左边第一个赋值1，如果满足+1，不满足为1
    再贪右边，从右边开始遍历，在满足第一次的基础上右边第一个赋值max（1，第一次），如果左比右大+1，不满足赋值max（1，第一次）
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 0; i < ratings.length - 1; i++) {
            candy[i + 1] = ratings[i] < ratings[i + 1] ? candy[i] + 1 : 1;
        }
        for (int i = candy.length - 1; i > 0; i--) {
            candy[i - 1] = ratings[i - 1] > ratings[i] ? Math.max(candy[i - 1], candy[i] + 1) : Math.max(1, candy[i - 1]);
        }
        return Arrays.stream(candy).sum();
    }

    public static void main(String[] args) {
        _12_Candy candy = new _12_Candy();
        System.out.println(candy.candy(new int[]{1,0,2}));
    }

}
