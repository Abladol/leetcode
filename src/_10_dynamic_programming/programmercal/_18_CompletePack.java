package _10_dynamic_programming.programmercal;

import java.util.Scanner;

/**
 *

 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，
 但是他的行李箱空间有限。这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的重量，并且具有不同的价值。

 小明的行李箱所能承担的总重量为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料可以选择无数次，并且可以重复选择。
 * @author AiJun
 * @date 2024/10/29 13:43
 * @version 1.0
 */
public class _18_CompletePack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N =scanner.nextInt();
        int V =scanner.nextInt();
        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
            values[i]=scanner.nextInt();
        }
        //完全背包问题要用一维数组
        int[] dp = new int[V+1];
        //递推，遍历物品
        for (int i = 0; i < N; i++) {
            //遍历空间
            for (int j = 0; j < V + 1; j++) {
                //如果能放下这个物品
                if(weights[i]<= j){
                    //这里可能会以为只增加了一个新的物品，但是实际上空间从0开始遍历，意味着只要这个物品放得下并且价值比之前大，那么就是能放几个就放几个
                    dp[j]=Math.max(dp[j],dp[j-weights[i]]+values[i]);
                }
            }
        }
        System.out.println(dp[V]);
    }
}
