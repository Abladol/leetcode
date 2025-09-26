package _09_greedy_algorithm.programmercal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意: 可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 */
public class _18_EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] x) -> x[0]).thenComparing((int[] x) -> x[1]));
        int count = 0;
        int minRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //重合了
            if (minRight > intervals[i][0]) {
                count++;
                //我们需要找到重合的最小公共区间，然后删除掉长的那一段，下一次比较右端点的时候比较的是最小公共区间的右端点
                minRight = Math.min(minRight, intervals[i][1]);
            }
            //没有重合就更新右节点
            else {
                minRight = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _18_EraseOverlapIntervals eraseOverlapIntervals = new _18_EraseOverlapIntervals();
        System.out.println(eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {3, 5}, {4, 6}}));
    }
}
