package _12_graph_theory;

import java.security.DigestInputStream;
import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个由 1（陆地）和 0（水）组成的矩阵，计算岛屿的最大面积。岛屿面积的计算方式为组成岛屿的陆地的总数。岛屿由水平方向或垂直方向上相邻的陆地连接而成，并且四周都是水域。你可以假设矩阵外均被水包围。
 * <p>
 * Last Modified:
 * @date 2024/12/13 9:04
 */
public class _07_LargestAreaOfIsland {
    private static int[][] matrix;
    private static final int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int temp = 0;
    private static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //深度搜索
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //这是深度搜索的入口，也就是陆地的第一块面积，所以先确保是陆地，再进行深度搜索
                if (matrix[i][j] == 1) {
                    matrix[i][j]=0;
                    temp++;
                    DFS(i, j);
                    //到达这里说明当前这一块陆地全部搜索完毕
                    res= Math.max(res, temp);
                    temp=0;
                }
            }
        }
        System.out.println(res);
    }

    public static void DFS(int x, int y) {
        //新的方向
        for (int i = 0; i < 4; i++) {
            int nextX = x + DIR[i][0];
            int nextY = y + DIR[i][1];
            //判断是否超出边界，或者不在陆地上，如果在陆地上面积+1，
            if (nextX < 0 || nextY < 0 || nextY >= matrix[0].length || nextX >= matrix.length || matrix[nextX][nextY] == 0) {
                continue;
            } else {
                //先标记这个地方已经被访问，直接标记为海洋即可
                matrix[nextX][nextY] = 0;
                temp++;
                DFS(nextX,nextY);
            }
        }
    }
}

