package hot100._13_heap;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * Last Modified:
 * @date 2025/3/2 20:44
 */
public class _075_TopKFrequent {
    /*
    我的思路：使用map记录每个次数，然后使用大顶堆，java实现了大顶堆了
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //选前k个
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue()+o2.getValue();
            }
        });

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(entry);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }
        return Arrays.stream(list.toArray()).mapToInt(x->Integer.parseInt(x.toString())).toArray();
    }

    public static void main(String[] args) {
        _075_TopKFrequent topKFrequent = new _075_TopKFrequent();
        int[] nums = new int[]{1,1,1,1,2,2,3,3,3,3};
        int[] res = topKFrequent.topKFrequent(nums, 1);
        System.out.println(Arrays.toString(res));
    }

}

