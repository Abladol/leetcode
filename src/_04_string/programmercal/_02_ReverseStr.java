package _04_string.programmercal;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 */
public class _02_ReverseStr {
    public static String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        char temp;
        for (int i = 0; i < ss.length; i += 2 * k) {
            int j = i;
            int tail = i + k - 1;
            //长度不够
            if (tail >= ss.length - 1) {
                tail = ss.length - 1;
            }

            while (j < tail) {
                temp = ss[j];
                ss[j] = ss[tail];
                ss[tail] = temp;
                j++;
                tail--;
            }


        }
        return new String(ss); //因为要返回的是字符串
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("heleossjiod", 4));
    }

}
