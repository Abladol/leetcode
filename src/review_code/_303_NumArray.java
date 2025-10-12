package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：  NumArray(int[] nums) 使用数组 nums 初始化对象 int sumRange(int i, int j)
 * 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点
 * （也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 * <p>
 * Last Modified:
 * @date 2025/10/12 14:32
 */
public class _303_NumArray {
    private int[] prefix;

    public _303_NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        if (nums.length >= 1) {
            prefix[1] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        _303_NumArray numArray = new _303_NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(2, 5));
    }
}

