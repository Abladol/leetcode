package hot100._06_matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * Last Modified:
 * @date 2025/1/5 16:25
 */
public class _019_SpiralOrder {
    /*
    我的思路就是构建一个方向数组，然后依次进行遍历,这个代码是存在问题的，因为在我的循环体里面我是先判断一个点位在不在边界内，在的话添加进去，如果达到边界了，那么进行
    下一个方向，在下一个方向的时候添加这个点，会导致最后一个点位无法添加进去
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] flag = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] position = new int[]{0, 0};
        int line = matrix.length;
        int col = matrix[0].length;
        int right = col - 1;
        int left = 0;
        int top = 0;
        int bottom = line - 1;
        List<Integer> res = new ArrayList<>(line * col);
        while (left <= right && bottom >= top) {
            //左向右
            while (left <= right && position[1] < right) {
                res.add(matrix[position[0]][position[1]]);
                position[0] += flag[0][0];
                position[1] += flag[0][1];
            }
            top++;
            //上向下
            while (bottom >= top && position[0] < bottom) {
                res.add(matrix[position[0]][position[1]]);
                position[0] += flag[1][0];
                position[1] += flag[1][1];
            }
            right--;
            //右到左
            while (left <= right && position[1] > left) {
                res.add(matrix[position[0]][position[1]]);
                position[0] += flag[2][0];
                position[1] += flag[2][1];
            }
            bottom--;
            //下到上
            while (bottom >= top && position[0] > top) {
                res.add(matrix[position[0]][position[1]]);
                position[0] += flag[3][0];
                position[1] += flag[3][1];
            }
            left++;
        }
        return res;
    }

    /*
    官方答案：
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // 从右到左
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }
            bottom--;
            // 从下到上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }


    public static void main(String[] args) {
        _019_SpiralOrder spiralOrder = new _019_SpiralOrder();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(new int[][]{{1, 2, 3}, {4,5,6}, {7,8,9}}).toArray()));
    }
}

