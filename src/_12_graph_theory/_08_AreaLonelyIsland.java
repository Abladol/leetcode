package _12_graph_theory;

import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个由 1（陆地）和 0（水）组成的矩阵，岛屿指的是由水平或垂直方向上相邻的陆地单元格组成的区域，且完全被水域单元格包围。孤岛是那些位于矩阵内部、所有单元格都不接触边缘的岛屿。    现在你需要计算所有孤岛的总面积，岛屿面积的计算方式为组成岛屿的陆地的总数。
 * <p>
 * Last Modified:
 * @date 2024/12/13 9:39
 */
public class _08_AreaLonelyIsland {
    private static int[][] matrix;
    private static final int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int temp = 0;
    private static int res = 0;
    private static boolean flag = true;

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                    //如果不是孤岛
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        flag=false;
                        DFS(i, j);
                    } else {
                        flag=true;
                        temp++;
                        DFS(i, j);
                        res += temp;
                        temp = 0;
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + DIR[i][0];
            int nextY = y + DIR[i][1];
            //判断是否超出边际以及是否是陆地
            if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length || matrix[nextX][nextY] == 0) {
                continue;
            } else if (!flag || nextX == 0 || nextX == matrix.length - 1 || nextY == 0 || nextY == matrix[0].length - 1) {
                matrix[nextX][nextY] = 0;
                temp=0;
                flag=false;
                DFS(nextX, nextY);
            } else {
                matrix[nextX][nextY] = 0;
                temp++;
                flag=true;
                DFS(nextX, nextY);
            }
        }
    }
}

