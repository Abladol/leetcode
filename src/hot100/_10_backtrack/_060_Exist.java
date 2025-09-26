package hot100._10_backtrack;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。  单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * Last Modified:
 * @date 2025/2/19 20:52
 */
public class _060_Exist {
    /*
    我的思路：dfs，还要建立一个数组用于标记已经使用过的字母，并且还要保证搜索是连续的
     */
    private int[][] used;
    private int[][] orientation = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    private StringBuffer s;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                used = new int[board.length][board[0].length];
                s = new StringBuffer();
                s.append(board[i][j]);
                used[i][j] = 1;
                boolean flag = retrace(board, word, i, j);
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean retrace(char[][] board, String word, int x, int y) {
        if (s.length() == word.length()) {
            return word.equals(s.toString());
        } else {
            String test = word.substring(0, s.length());
            if (!test.contentEquals(s)) return false;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + orientation[i][0];
            int newY = y + orientation[i][1];
            //判断是否越界
            if (0 <= newX && newX < board.length && 0 <= newY && newY < board[0].length && used[newX][newY] == 0) {
                s.append(board[newX][newY]);
                used[newX][newY] = 1;
                boolean flag = retrace(board, word, newX, newY);
                if (flag) return true;
                else {
                    s.deleteCharAt(s.length() - 1);
                    used[newX][newY] = 0;
                    continue;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _060_Exist exist = new _060_Exist();
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESCC"));
    }
}

