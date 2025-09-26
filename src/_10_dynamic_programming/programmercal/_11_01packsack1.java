package _10_dynamic_programming.programmercal;

import java.util.Scanner;

/**
 * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，但是他的行李箱空间有限。
 * 这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的空间，并且具有不同的价值。
 * 小明的行李空间为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
 */
public class _11_01packsack1 {
    /*
    第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
    第二行包含 M 个正整数，代表每种研究材料的所占空间。
    第三行包含 M 个正整数，代表每种研究材料的价值。
     */
    public int packsack() {
        Scanner scanner = new Scanner(System.in);
        int materialNum = scanner.nextInt();
        int spaceSize = scanner.nextInt();
        int[] materialSize = new int[materialNum];
        int[] materialValue = new int[materialNum];

        for (int i = 0; i < materialNum; i++) {
            materialSize[i] = scanner.nextInt();
        }
        for (int i = 0; i < materialNum; i++) {
            materialValue[i] = scanner.nextInt();
        }

        //因为是0-1背包问题，每个物品只能取一次
        //1.初始化
        //构建dp数组，横轴是材料种类，纵轴是背包容量，dp[i][j]表示，放第0到i个物品，空间为j的最大价值
        //dp数组含义：dp[i][j]：容量为j的 背包取其中0到i的物品，最大价值
        int[][] dp = new int[materialNum][spaceSize+1];
        for (int i = 0; i <= spaceSize; i++) {
            if (materialSize[0] <= i) {
                dp[0][i] = materialValue[0];//当背包容量能容纳第0个物品的时候，最大价值就是该物品价值
            }
        }
        for (int i = 0; i < materialNum; i++) {
            dp[i][0] = 0;//背包容量为0，直接初始化为0
        }


        //2.递推
        //dp[i][j]=max{不放第i个物品，放上第i个物品}
        //放上第i个物品，先给第i个物品腾出空间，剩余空间为dp[i-1][j-]
        for (int i = 1; i < materialNum; i++) {
            for (int j = 1; j <= spaceSize; j++) {
                if(j>=materialSize[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - materialSize[i]] + materialValue[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[materialNum-1][spaceSize];
    }

    public static void main(String[] args) {
        _11_01packsack1 packsack1 = new _11_01packsack1();
        System.out.println(packsack1.packsack());
    }
}
