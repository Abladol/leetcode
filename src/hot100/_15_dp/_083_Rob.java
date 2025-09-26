package hot100._15_dp;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。  给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * Last Modified:
 * @date 2025/2/18 20:24
 */
public class _083_Rob {
    /*
    我的思路：先确认dp数组定义：到第n家的最大利润，dp[i]=math.max（上一家不偷的利润+偷这一家，偷上一家+不偷这家)
             记住dp[i]无法确保偷了第i家还是没有，保证的是到第i家利润的最大值
     */
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        _083_Rob rob = new _083_Rob();
        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
    }
}

