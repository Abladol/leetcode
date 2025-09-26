package _09_greedy_algorithm.programmercal;

/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个
 * 不等元素的序列也视作摆动序列。
 * <p>
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * <p>
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 */
public class _03_WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int result = 1;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                result++;
                //这是关键，只有当找到峰值或者谷值时才变换prediff的值，这样可以避免单调平坡，其实是相当于我们忽略了prediff和curdiff之间的节点
                preDiff = curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _03_WiggleMaxLength wiggleMaxLength = new _03_WiggleMaxLength();
        System.out.println(wiggleMaxLength.wiggleMaxLength(new int[]{1, 2, 2,3}));
    }
}
