package hot100._14_greedy_algorithm;

import com.sun.jdi.event.StepEvent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:  0 <= j <= nums[i]  i + j < n 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * Last Modified:
 * @date 2025/2/24 21:05
 */
public class _079_Jump {
    /*
    我的思路：我觉得可以使用动态规划来写
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前位置能跳的步数
            int c = nums[i];
            //计算后面能到达的最小步数
            for (int j = i + 1; j <= i + c && j < nums.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
                if (j == nums.length - 1) {
                    return dp[j];
                }
            }
        }
        return dp[nums.length - 1];
    }


    /*
    也可以使用贪心算法
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域 
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        _079_Jump jump = new _079_Jump();
        System.out.println(jump.jump2(new int[]{2, 3, 1, 1, 4}));
    }
}

