package hot100._05_ordinary_array;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * Last Modified:
 * @date 2025/1/3 16:38
 */
public class _014_Merge {

    /*
    我的思路：既然要合并区间，首先就要判断哪些区间需要合并，所以我们可以先对子数组进行排序，按早区间左端点由小到大排序，
            如果当前区间的右端点在下一个区间的左端点的左边（不包括左端点）说明这两个区间是不可以合并的
            如果当前区间的右端点在下一个区间的左端点的右边（包括左端点）说明这两个区间是可以合并的，新区间的左端点就是当前区间的左端点，新区间的右端点应该是这两个区间右端点的最大值
            那么合并的区间就可以放入res中，继续和下下个区间比较
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] temp = new int[]{intervals[0][0],intervals[0][1]};
        for (int i = 0; i < intervals.length-1; i++) {
            if(temp[1]>=intervals[i+1][0]){
                temp[1] = Math.max(temp[1],intervals[i+1][1]);
                temp[0]=temp[0];
            }else {
                res.add(Arrays.copyOf(temp,2));
                temp[0]=intervals[i+1][0];
                temp[1]=intervals[i+1][1];
            }
        }
        res.add(temp);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        _014_Merge merge = new _014_Merge();
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 6}, {2, 4}, {3, 5}, {8, 10}})));
    }
}

