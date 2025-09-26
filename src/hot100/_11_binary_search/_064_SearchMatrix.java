package hot100._11_binary_search;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个满足下述两条属性的 m x n 整数矩阵：  每行中的整数从左到右按非严格递增顺序排列。 每行的第一个整数大于前一行的最后一个整数。 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * Last Modified:
 * @date 2025/2/16 20:04
 */
public class _064_SearchMatrix {
    /*
    我的思路：既然是有序的，可以先确认在第几行，然后在该行进行二分查找
    标准答案基本在我的第一个if判断上进行优化，对第一列使用二分查找就可以确认元素所在的行，我的方法效率会很慢，类似于暴力
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][l] <= target && matrix[i][r - 1] >= target) {
                //说明可能在这一行进行二分查找
                while (l<=r) {
                    int m = (l + r) / 2;
                    if (matrix[i][m] == target) return true;
                    else if (matrix[i][m] < target) l = m + 1;
                    else r = m - 1;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _064_SearchMatrix searchMatrix= new _064_SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {9, 10, 13, 27}, {30, 34, 46, 48}, {50, 53, 58, 99}}, 1));
    }
}

