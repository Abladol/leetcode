package _09_greedy_algorithm.programmercal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend]
 * 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 *
 */
public class _17_FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        int count =0;
        Arrays.sort(points, Comparator.comparing((int[] x)->x[0]).thenComparing(x->x[1]));
        int right = points[0][1];
        for (int i = 0; i < points.length-1; i++) {
            if(right>=points[i+1][0]){
                right = Math.min(right,points[i+1][1]);
            }else {
                count++;
                right = points[i+1][1];
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        _17_FindMinArrowShots findMinArrowShots = new _17_FindMinArrowShots();
        System.out.println(findMinArrowShots.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }
}
