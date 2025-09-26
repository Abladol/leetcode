package _09_greedy_algorithm.programmercal;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class _08_Jump2 {
    public int jump(int[] nums) {
        if (nums==null || nums.length == 1) {
            return 0;
        }
        int step = 0;
        int cur = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //找到下一步的最大范围
            max = Math.max(max, nums[i] + i);
            //已经走到当前这步最远的地方了
            if (i == cur) {
                //直接跳到最远的地方进行下一步
                step++;
                cur = max;
            }
            //成功了
            if (cur >= nums.length-1) {
                return step + 1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        _08_Jump2 jump2 = new _08_Jump2();
        System.out.println(jump2.jump(new int[]{2,3,1,1,4}));
    }
}
