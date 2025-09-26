package _10_dynamic_programming.programmercal;

import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author AiJun
 * @version 1.0
 * @date 2024/10/30 15:45
 */
public class _22_ClimbStairs2 {
    //完全背包，排列问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(); //台阶
        int m= scanner.nextInt();
        int[] dp=new int[n+1];
        dp[0]=1;
        //遍历台阶
        for (int i = 1; i < n+1; i++) {
            //遍历物品
            for (int j = 1; j < m+1; j++) {
                //如果装的下物品
                if(j<=i){
                    dp[i]=dp[i]+dp[i-j];  //方法总数=不装这个物品的方法数dp[i]+装这个物品的方法数dp[i-j]
                }
            }
        }
        System.out.println(dp[n]);
    }
}
