package _10_dynamic_programming.programmercal;


import java.util.Scanner;

/**
 * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。他需要带一些研究材料，但是他的行李箱空间有限。
 * 这些研究材料包括实验设备、文献资料和实验样本等等，它们各自占据不同的空间，并且具有不同的价值。
 * 小明的行李空间为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
 */
public class _12_02packsack2 {
    public static int packsack() {
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

        //定义dp数组，dp[i]，容量为i的背包的最大价值
        int[] dp = new int[spaceSize + 1];

        //递推
        //容量为j的背包，放第i个物品的最大价值
        for (int i = 0; i < materialNum; i++) {
            /*这里面如果正序遍历，会重复添加，比如dp[1]就是容量为1的背包，放第一个物品，dp[2]=max{dp[2-第一个物品重量]+第一个物品的value}，
            这个时候dp[2-第一个物品重量]里面已经放上第一个物品了可能，所以 会重复放，所以倒排
             */
            for (int j = spaceSize; j >= 0; j--) {
                //最大价值=max{不放物品i，放物品i}
                if (j >= materialSize[i]) {
                    dp[j] = Math.max(dp[j - materialSize[i]] + materialValue[i], dp[j]);
                }
            }
        }
        return dp[spaceSize];
    }

    public static void main(String[] args) {
        System.out.println(packsack());
    }

}
