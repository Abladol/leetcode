package hot100._14_greedy_algorithm;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * Last Modified:
 * @date 2025/2/17 19:53
 */
public class _078_CanJump {
    /*
    我的思路：不断更新我能到达的最远距离就可以了
     */
    public boolean canJump(int[] nums) {
        int maxInstance = nums[0];
        int end = nums.length - 1;
        for (int i = 1; i <= maxInstance && i<=end; i++) {
            maxInstance = Math.max(maxInstance, i + nums[i]);
            if (maxInstance >= end) return true;
        }
        return maxInstance>=end;
    }

    public static void main(String[] args) {
        _078_CanJump canJump = new _078_CanJump();
        System.out.println(canJump.canJump(new int[]{1,2,3}));
    }
}

