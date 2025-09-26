package hot100._06_matrix;

import java.util.Arrays;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * Last Modified:
 * @date 2025/1/6 14:28
 */
public class _020_Rotate {

    /*
    旋转的规律为（i，j）旋转后为（j，n-i-1）,增加一个数组标记元素是否被旋转
     */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        boolean[][] flag = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!flag[i][j]) {
                    change(i, j, matrix, flag);
                }
            }
        }
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    public void change(int i, int j, int[][] matrix, boolean[][] flag) {
        int n = matrix.length;
        int temp1;
        int temp2 = matrix[i][j];
        while (!flag[i][j]) {
            //被使用，就是下一次确定位置的值
            temp1 = matrix[j][n - i - 1];
            matrix[j][n - i - 1] = temp2;
            //使用者
            temp2 = temp1;
            flag[i][j] = true;
            //跳到一个新的位置上去交换
            int k = j;
            j = n - i - 1;
            i = k;
        }
    }


    /*
    标准答案：思路大致一样，不使用标志矩阵，因为第一我们替换的次数是固定的，四次，第二我们不需要遍历每一个元素，我们只需要遍历矩阵的一半的一半，每次都是从这个小矩阵开始遍历
            遍历4次就全部遍历完成了，第二个说明了不需要使用标志数组
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        _020_Rotate rotate = new _020_Rotate();
        rotate.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}

