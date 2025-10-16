package review_code;

import java.security.DigestException;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 字母迷宫,字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。
 * 注意：寻找单词时 必须 按照字母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。
 * <p>
 * Last Modified:
 * @date 2025/10/14 16:10
 */
public class LCR129_WordPuzzle {
    private boolean[][] visited;
    private final int[][] diractions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private StringBuilder temp;

    public boolean wordPuzzle(char[][] grid, String target) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited = new boolean[grid.length][grid[0].length];
                visited[i][j] = true;
                temp = new StringBuilder();
                temp.append(grid[i][j]);
                boolean flag =  retrace(grid, target, i, j, 0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean retrace(char[][] grid, String target, int x, int y, int index) {
        if (index + 1 == target.length() && temp.toString().equals(target)) {
            return true;
        }
        if (temp.charAt(index) != target.charAt(index)) {
            return false;
        }
        for (int i = 0; i < diractions.length; i++) {
            int newX = x + diractions[i][0];
            int newY = y + diractions[i][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || visited[newX][newY]) {
                continue;
            }
            temp.append(grid[newX][newY]);
            visited[newX][newY] = true;
            boolean flag = retrace(grid, target, newX, newY, index + 1);
            if (flag) {
                return true;
            }
            visited[newX][newY] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        LCR129_WordPuzzle wordPuzzle = new LCR129_WordPuzzle();
        System.out.println(wordPuzzle.wordPuzzle(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABQCED"));

    }
}

