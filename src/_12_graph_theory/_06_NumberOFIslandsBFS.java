package _12_graph_theory;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
 * @date 2024/12/11 11:22
 */
public class _06_NumberOFIslandsBFS {

    //定义方向，上右下左
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] matrix;
    static Deque<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        int res = 0;
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
                if(matrix[i][j]==0){
                    continue;
                }
                matrix[i][j]=0;
                res++;
                BFS(i,j);
            }
        }
        System.out.println(res);
    }

    public static void BFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            //判断是否在边界内
            if (nextX < 0 || nextY < 0 || nextY >= matrix[0].length || nextX >= matrix.length || matrix[nextX][nextY] == 0) {
                continue;
            }
            //标记为访问过了，直接标记为海洋=0，标记完成再入队列
            matrix[nextX][nextY]=0;
            queue.offerLast(new int[]{nextX,nextY});
        }
        //BFS，依次取出队列，继续搜索
        while (!queue.isEmpty()){
            int[] temp = queue.pollFirst();
            BFS(temp[0],temp[1]);
        }
    }
}

