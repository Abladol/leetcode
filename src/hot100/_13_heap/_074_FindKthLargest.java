package hot100._13_heap;

import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。  你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * Last Modified:
 * @date 2025/3/2 20:03
 */
public class _074_FindKthLargest {
    /*
    根据参考答案的桶排序写的算法：对于桶排序，实际上是构建一个桶，然后将nums映射到桶里面去，桶可以是先排好序的，然后依次将数值放入桶里面，这个可以放入数值，也可以放入个数，还可以放入序号
    对于本题放入个数即可，然后从最大的桶依次循环找到第k个
     */
    public int findKthLargest(int[] nums, int k) {
        //因为题目对于数值的范围是正负10000
        int[] bucket = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + 10000]++;
        }
        for (int i = 20000; i > 0; i--) {
            k = k - bucket[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ss = s.substring(1, s.length() - 1);
        String[] strings = ss.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int k = sc.nextInt();

        _074_FindKthLargest findKthLargest = new _074_FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, k));
    }
}

