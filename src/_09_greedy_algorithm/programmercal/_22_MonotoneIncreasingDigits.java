package _09_greedy_algorithm.programmercal;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 */
public class _22_MonotoneIncreasingDigits {
    //从后向前遍历更方便
    public int monotoneIncreasingDigits(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int res = 0;
        int flag = -1;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                //一旦i-1减1，后面的值可以全部变成9
                chars[i - 1]--;
                flag = i;
            }
        }
        if (flag != -1) {
            for (int i = flag; i < chars.length; i++) {
                chars[i]='9';
            }
        }
        for (int i = 0; i < chars.length; i++) {
            res += (chars[i] - '0') * Math.pow(10, chars.length - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        _22_MonotoneIncreasingDigits monotoneIncreasingDigits = new _22_MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(211));
    }
}
