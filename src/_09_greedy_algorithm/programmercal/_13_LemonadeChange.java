package _09_greedy_algorithm.programmercal;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class _13_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] type = new int[]{0, 0, 0};
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                type[0]++;
            }
            else if (bills[i] == 10) {
                if (type[0] > 0) {
                    type[0]--;
                    type[1]++;
                } else {
                    return false;
                }
            }
            else if (bills[i] == 20) {
                if (type[1] > 0 && type[0] > 0) {
                    type[0]--;
                    type[1]--;
                    type[2]++;
                } else if (type[0] >= 3) {
                    type[0] = type[0] - 3;
                    type[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _13_LemonadeChange lemonadeChange = new _13_LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5,5,5,5,20,20,5,5,20,5}));
    }
}
