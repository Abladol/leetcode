package _10_dynamic_programming.programmercal;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class _16_FindTargetSumWays {
    /*
    思路：将所有的数分为两类，一类是加法A，一类是减法B，所以a+b=sum,a-b=target,sum和target是已知的，那么两个式子相加，2a=sum+target，
    此时，a是可以求出来的，那么题目就转换为从nums中选取数求和为a，有多少种可能，
    注意：如果你是求a，那么有一种特殊情况存在0，如果存在0，那么方法数就要乘2，因为0前面可以去任意符号
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;
        }
        int size = (sum + target)/2 ;
        if((sum+target)%2!=0||Math.abs(target)>sum){
            return 0;
        }
        int[][] dp = new int[nums.length][size+1];

        //初始化dp，第0个物品填满空间
        for (int i = 0; i < size + 1; i++) {
            if(nums[0]==i) {
                dp[0][i]=1;
            }
        }
        //注意0的存在，按理说没有0，填满空间为0的包的方法都是1，就是什么都不放，但是如果有0，正负都可以，填满dp数组最左边一列
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                count++;
            }
            //只要有一个0就会有两种情况要0或者不要0
            dp[i][0]= (int) Math.pow(2,count);
        }
        //递推
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < size + 1; j++) {
                if(nums[i]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]];//不加上第i个+加上第i个
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][size];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{100}, -200));
    }
}

