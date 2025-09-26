package _09_greedy_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class _20_Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] x) -> x[0]).thenComparing((int[] x) -> x[1]));
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //当前子数组的左边小于前一个最大的右边，说明有重叠
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
                continue;
            }
            //没有重叠
            res.add(new int[]{left, right});
            left = intervals[i][0];
            right = intervals[i][1];
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        _20_Merge merge = new _20_Merge();
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 3}, {5, 6}, {6, 10}})));
    }
}
