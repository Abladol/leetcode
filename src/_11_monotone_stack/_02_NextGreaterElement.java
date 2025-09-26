package _11_monotone_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。  请你找出 nums1 中每个元素在 nums2
 * 中的下一个比其大的值。  nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * Last Modified:
 * @date 2024/11/29 10:11
 */
public class _02_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //先找到mums2每一个元素对应的答案
        Deque<Integer> stack = new LinkedList<>();
        int[] res2 = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            if(stack.peek()!=null && nums2[i]>nums2[stack.peek()]){
                res2[stack.peek()]=nums2[i];
                stack.pollFirst();
                i--;
            }else {
                stack.offerFirst(i);
            }
        }
        int[] res1= new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    res1[i]=res2[j]==0?-1:res2[j];
                    break;
                }
            }
        }
        return res1;
    }

    public static void main(String[] args) {
        _02_NextGreaterElement nextGreaterElement = new _02_NextGreaterElement();
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}

