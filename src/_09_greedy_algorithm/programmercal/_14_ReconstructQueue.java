package _09_greedy_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）
 * 。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj]
 * 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 */
public class _14_ReconstructQueue {
    /*
    贪心有两个维度，一个是升高，一个是顺序，顺序实际上是明确的，我们没必要先贪顺序，所以我们先贪升高，然后贪顺序
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,Comparator.comparingInt((int[] x) -> -x[0]).thenComparingInt((int[] x) -> x[1]));
        List<int[]> peop = new ArrayList<>();
        for (int[] p : people) {
            peop.add(p[1],p);
        }
        return  peop.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        _14_ReconstructQueue reconstructQueue = new _14_ReconstructQueue();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = reconstructQueue.reconstructQueue(people);
        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
