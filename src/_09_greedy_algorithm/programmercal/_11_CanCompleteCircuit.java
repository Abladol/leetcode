package _09_greedy_algorithm.programmercal;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class _11_CanCompleteCircuit {

    /*
    整体思路：假设有一段路，A-B-C-D-E，a到b油量是正，再到c油量还是正，到d油量为负，那么a作为出发点是不可以的，只能从为负的下一出发点尝试
    理由：bcd为什么不可以，假设b可以，那么ab+bc+cd<0,ab>0,bc>0,则bc+cd一定小于0
     */

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remain = new int[2 * gas.length];
        int sum = 0;
        int start = 0;
        int j = 0;
        for (int i = 0; i < gas.length; i++) {
            remain[i] = gas[i] - cost[i];
            remain[i + gas.length] = gas[i] - cost[i];
        }

        while (j - start < gas.length && start < gas.length) {
            sum += remain[j];
            if (sum < 0) {
                start = j + 1;
                sum = 0;
            }
            j++;
        }
        if (start < gas.length) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        _11_CanCompleteCircuit canCompleteCircuit = new _11_CanCompleteCircuit();
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));
    }
}
