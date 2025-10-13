package _00_array.programmercarl;
import java.util.Arrays;


/**
 * 螺旋数组
 * 题目描述：
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * <p>
 * 解题思路：
 * 1. 循环圈数，n/2, n为奇数时，最后一个元素单独处理
 */
public class SpiralArray {

    public static int[][] mySpiralArray(int n) {
        int count = 1;
        int[][] spiralArray = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            // 从左到右
            for (int j = i; j < n - i - 1; j++) {
                spiralArray[i][j] = count;
                count++;
            }
            // 从上到下
            for (int j = i; j < n - i - 1; j++) {
                spiralArray[j][n - i - 1] = count;
                count++;
            }
            // 从右到左
            for (int j = n - i - 1; j > i; j--) {
                spiralArray[n - i - 1][j] = count;
                count++;
            }
            // 从下到上
            for (int j = n - i - 1; j > i; j--) {
                spiralArray[j][i] = count;
                count++;
            }
        }
        if (n % 2 ==1) {
            spiralArray[n / 2 ][n / 2 ] = count;
        }
        return spiralArray;
    }

    public static void main(String[] args) {
        for (int[] ints : mySpiralArray(5)) {
            System.out.println(Arrays.toString(ints));
        }
    }

}

