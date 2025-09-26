package hot100._04_substring;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。  返回 滑动窗口中的最大值 。
 * <p>
 * Last Modified:
 * @date 2024/12/25 9:04
 */
public class _011_MaxSlidingWindow {
    /*个人思路：这道题的关键在于如何快速找到窗口内最大的元素，第一点，每次移动窗口都只会增加一个元素，而上一个窗口的最大值是知道的，问题在于新加一个元素就会删除一个元素
    如果删除的那个元素是最大的那个元素，我们就要和第二大元素比较，所以我们要将这些元素排序，可以用队列，然后判断这个数在不在这个窗口中，所以队列中存储索引
    第二点，明确一点：比如第i个元素是目前最大的，那么前i-1个元素是没有必要存储的，因为这个窗口是依次向后的，所以只要有第i个元素，前i-1个元素就没有意义，这样就保证
    队列的单调性
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(nums.length - k);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (queue.peekLast() != null && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i >= k-1) {
                //队列的头部的元素是最大的，判断是否在窗口区间，如果在添加，不在从队列中删除
                while (i - k >= queue.peekFirst()) {
                    queue.pollFirst();
                }
                res.add(nums[queue.peekFirst()]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
    官方答案：思路基本一致，在其中一个部分不一样，就是我的方法中队列存储的是索引，然后根据索引判断是否在窗口中，官方答案则是直接存储值，然后每次都会判断窗口最左边的数是否等于
            队列的头部元素，也就是最大的元素，因为如果相等，下一步循环这个数要被删除很好理解，唯一问题是会不会窗口之前的数还存在于队列中？
            这是不可能的，因为队列的元素不仅是按大小排序，其进队的顺序是原数组的顺序，就是说队列元素ab，a在b左边，那么原数组中a一定在b左边，所以只需要判断队列最老的一个元素
            是不是需要被删除就可以了，这里用最老的元素更容易理解，如果用最大的元素其实不容易理解
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        _011_MaxSlidingWindow maxSlidingWindow = new _011_MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}

