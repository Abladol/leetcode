package hot100._06_matrix;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：  每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 * <p>
 * Last Modified:
 * @date 2025/1/6 14:56
 */
public class _021_SearchMatrix {
    /*
    我的思路：使用回溯算法，向右向下搜索，存在超时例子
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //行的边界
        int m = matrix.length;
        //列的边界
        int n = matrix[0].length;
        return retrace(0, 0, m, n, matrix, target);
    }

    public boolean retrace(int i, int j, int m, int n, int[][] matrix, int target) {
        if (matrix[i][j] == target) {
            return true;
        }
        boolean flag = false;
        //先向右，再向下
        if (j < n - 1 && matrix[i][j] < target) {
            flag = retrace(i, j + 1, m, n, matrix, target);
        }
        if (flag) return true;
        if (i < m - 1 && matrix[i][j] < target) {
            flag = retrace(i + 1, j, m, n, matrix, target);
        }
        return flag;
    }

    /*
    标准答案：我的思路存在一个缺陷：我的思路是从左上角搜索，那么右边和下边都比当前值大，我们要分两路去搜索再依次比较，如果改变搜索方向，
            比当前值大的向一个方向，比当前值小耳朵向另一个方向，复杂度会减半，所以我们可以使用从右上角搜索，因为左边的元素比他小，下面的元素比他大
            我们将矩阵逆时针旋转 45° ，并将其转化为图形式，发现其类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、右分支元素更大。
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // 从右上角开始
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // 当前值大于目标值，向左移动
            } else {
                row++; // 当前值小于目标值，向下移动
            }
        }

        return false; // 遍历完矩阵仍然没有找到目标值
    }

    public static void main(String[] args) {
        _021_SearchMatrix searchMatrix = new _021_SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }, 7));
    }


}

