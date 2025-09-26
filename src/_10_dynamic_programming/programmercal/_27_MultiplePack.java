package _10_dynamic_programming.programmercal;

import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 你是一名宇航员，即将前往一个遥远的行星。在这个行星上，有许多不同类型的矿石资源，每种矿石都有不同的重要性和价值。
 * 你需要选择哪些矿石带回地球，但你的宇航舱有一定的容量限制。
 * 给定一个宇航舱，最大容量为 C。现在有 N 种不同类型的矿石，每种矿石有一个重量 w[i]，一个价值 v[i]，以及最多 k[i] 个可用。不同类型
 * 的矿石在地球上的市场价值不同。你需要计算如何在不超过宇航舱容量的情况下，最大化你所能获取的总价值。
 * <p>
 * Last Modified:
 * @date 2024/11/1 15:38
 */
public class _27_MultiplePack {

    public static void main(String[] args) {
        /**
         * 输入共包括四行，第一行包含两个整数 C 和 N，分别表示宇航舱的容量和矿石的种类数量。
         * 接下来的三行，每行包含 N 个正整数。具体如下：
         * 第二行包含 N 个整数，表示 N 种矿石的重量。
         * 第三行包含 N 个整数，表示 N 种矿石的价格。
         * 第四行包含 N 个整数，表示 N 种矿石的可用数量上限。
         */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int num = scanner.nextInt();
        int[] weight = new int[num];
        int[] prices = new int[num];
        int[] num_max = new int[num];
        int[] dp = new int[size + 1];
        for (int i = 0; i < num; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            prices[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            num_max[i] = scanner.nextInt();
        }
        int count = num_max[0];
        //初始化
        for (int i = 0; i < size + 1; i++) {
            //如果能放下这个物品，并且还有这个物品
            if (count > 0 && weight[0] <= i) {
                dp[i] = dp[i - weight[0]] + prices[0];
                count--;
            } else if (count == 0) {
                dp[i] = dp[i - 1];
            }
        }
        //展开为01背包，多遍历一个物品个数
        //01背包 ，一维其实更简略
        for (int i = 1; i < num; i++) {
            //多一个遍历物品最多使用多少个
            for (int k = 0; k < num_max[i]; k++) {
                //遍历背包容量
                for (int j = size; j > 0; j--) {
                    //如果能装下
                    if (weight[i] <= j) {
                        dp[j] = Math.max(dp[j], dp[j - weight[i]] + prices[i]);
                    }
                }
            }
        }
        System.out.println(dp[size]);

    }
}

