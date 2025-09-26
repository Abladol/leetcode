package _12_graph_theory;

import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 题目描述：  给定一个由 1（陆地）和 0（水）组成的矩阵，你需要计算岛屿的数量。岛屿由水平方向或垂直方向上相邻的陆地连接而成，
 * 并且四周都是水域。你可以假设矩阵外均被水包围。
 * 输入描述：  第一行包含两个整数 N, M，表示矩阵的行数和列数。  后续 N 行，每行包含 M 个数字，数字为 1 或者 0。
 * 输出描述：  输出一个整数，表示岛屿的数量。如果不存在岛屿，则输出 0。
 * <p>
 * Last Modified:
 * @date 2024/12/11 10:28
 */
public class _05_NumberOFIslandsDFS {
    //定义方向，上右下左
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] matrix;

    public static void main(String[] args) {
        int res=0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        //遍历，如果遇到陆地，就计数器加1，说明发现陆地，进入dfs搜索，将这一块陆地全部搜索完，然后继续进行下一块陆地的搜索
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //如果是陆地进行搜索，不是陆地跳过
                if(matrix[i][j]==0){
                    continue;
                }
                res++;
                matrix[i][j]=0;
                dfs(i,j);
            }
        }
        System.out.println(res);
    }

    //将访问过的陆地直接标记为海洋=0
    public static void dfs(int x, int y) {
        //要运动到下一个坐标，也就是经历4个方向
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            //如果运动到超出边界，或者到达海洋则跳过
            if (nextX < 0 || nextY < 0 || nextY >= matrix[0].length || nextX >= matrix.length
                    || matrix[nextX][nextY] == 0) {
                continue;
            }
            //没有超出边界，将到达的陆地标记为已访问，直接标记为海洋
            matrix[nextX][nextY]=0;
            dfs(nextX,nextY);
        }
    }
}

