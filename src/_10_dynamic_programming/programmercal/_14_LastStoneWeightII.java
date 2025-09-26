package _10_dynamic_programming.programmercal;

import java.util.Arrays;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 */
public class _14_LastStoneWeightII {
    //可以理解为，分为两个部分，两个部分分别重量尽可能相等，然后互相撞，最后只会剩下一块，就是他们的差值。
    //因为分成两份后，总是从两堆里面选出一个出来，撞击之后如果有多余的，放回原来那堆，依次下去，最后就是两堆各自和的差值
    public static int lastStoneWeightII(int[] stones) {
        int size = Arrays.stream(stones).sum()/2;
        int[][] dp = new int[stones.length][size+1];

        //dp初始化
        for (int i = 0; i < size+1; i++) {
            if(i>=stones[0]){
                dp[0][i]=stones[0];
            }
        }

        //递归：i是物品，j是容积，就是我们期望组成的和
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j < size+1; j++) {
                //放得下第i个物品
                if(stones[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        //找到能两堆其中一堆的重量，这个重量尽可能接近总重量的一半，即为dp[end][end]
        int A= Arrays.stream(stones).sum() - dp[stones.length-1][size];
        int B = Arrays.stream(stones).sum()-A;
        return Math.abs(A-B);
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeightII(new int[]{1,2}));
    }
}
