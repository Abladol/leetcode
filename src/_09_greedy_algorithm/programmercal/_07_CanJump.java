package _09_greedy_algorithm.programmercal;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class _07_CanJump {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int i = 0; i <= max; i++) {
            if(max>=nums.length-1){
                return true;
            }
            temp = i+nums[i];
            max=Math.max(temp,max);
        }
        return false;

    }

    public static void main(String[] args) {
        _07_CanJump canJump = new _07_CanJump();
        System.out.println(canJump.canJump(new int[]{0}));

    }
}
