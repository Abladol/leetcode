package _04_string.programmercal;

/**
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * <p>
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 * <p>
 * 对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
 * <p>
 * 输入：一个字符串 s,s 仅包含小写字母和数字字符。
 * <p>
 * 输出：打印一个新的字符串，其中每个数字字符都被替换为了number
 * <p>
 * 样例输入：a1b2c3
 * <p>
 * 样例输出：anumberbnumbercnumber
 */
public class _03_ReplaceNumbers {
    public static String replaceNum(String s) {
        char[] ss = s.toCharArray();
        int count = 0;
        for (int i = 0; i < ss.length; i++) {
            //有几个数字
            if (Character.isDigit(ss[i])) {
                count++;
            }
        }

        char[] res = new char[5 * count + ss.length];
        int left = ss.length - 1;
        int right = res.length - 1;
        while (left < right || left >= 0) {
            if (Character.isDigit(ss[left])) {
                left--;
                res[right] = 'r';
                res[right - 1] = 'e';
                res[right - 2] = 'b';
                res[right - 3] = 'm';
                res[right - 4] = 'u';
                res[right - 5] = 'n';
                right -= 6;
            } else {
                res[right] = ss[left];
                left--;
                right--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(replaceNum("1hjh32ghiu"));
    }
}
