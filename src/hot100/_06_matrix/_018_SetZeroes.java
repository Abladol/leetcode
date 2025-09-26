package hot100._06_matrix;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * Last Modified:
 * @date 2025/1/5 16:09
 */
public class _018_SetZeroes {
    /*
     没有意义的题目，我的思路是先找到0的行和列分别用set存储，然后在进行赋值为0，标准解法和我思路差不多
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> line = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    line.add(i);
                    col.add(j);
                }
            }
        }
        //赋值为0
        for (Integer i : line) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=0;
            }
        }
        for (Integer i : col) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i]=0;
            }
        }
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        _018_SetZeroes setZeroes = new _018_SetZeroes();
        setZeroes.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

}

