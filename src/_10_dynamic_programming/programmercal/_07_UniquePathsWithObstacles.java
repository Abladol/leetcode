package _10_dynamic_programming.programmercal;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class _07_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //1.初始化
        int[][] dp = new int[m][n];
        //第一行和第一列都赋值为1
        for (int i = 0; i < n; i++) {
            //如果有障碍，该点及后面的赋值为0
            if (obstacleGrid[0][i] == 1) {
                break;//初始化的默认是0
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0]==1){
                break;
            }else {
                dp[i][0] = 1;
            }
        }
        //2.递推，每个单元的值是左边的上面的值相加
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    //控价优化版本
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        _07_UniquePathsWithObstacles uniquePathsWithObstacles = new _07_UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
