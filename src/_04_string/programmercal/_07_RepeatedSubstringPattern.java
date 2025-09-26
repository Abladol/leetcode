package _04_string.programmercal;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class _07_RepeatedSubstringPattern {
    // 移动匹配

    /**
     * 当一个字符串s：abcabc，内部由重复的子串组成，那么这个字符串的结构一定是这样的：也就是由前后相同的子串组成。
     * <p>
     * 那么既然前面有相同的子串，后面有相同的子串，用 s + s，这样组成的字符串中，后面的子串做前串，前面的子串做后串，就一定还能组成一个s，
     * 所以判断字符串s是否由重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是由重复子串组成。当然，我们在判断 s + s 拼接的
     * 字符串里是否出现一个s的的时候，要刨除 s + s 的首字符和尾字符，这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
     *不过这种解法还有一个问题，就是 我们最终还是要判断 一个字符串（s + s）是否出现过 s 的过程，大家可能直接用contains，find 之类的库函数。
     *  却忽略了实现这些函数的时间复杂度（暴力解法是m * n，一般库函数实现为 O(m + n)）。
     * @param s
     */
//    public static boolean repeatedSubstringPattern(String s) {
//        StringBuffer ss = new StringBuffer(s);
//        ss.append(ss);
//        ss.deleteCharAt(0);
//        ss.deleteCharAt(ss.length() - 1);
//        return ss.indexOf(s) != -1;
//    }


    /**
     * KMP
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);

        //构造next数组
        int[] next = new int[s.length()];
        char[] pattern = s.toCharArray();
        int i = 1;
        int j = 0;
        next[0] = 0;
        while (i < s.length()) {
            if (pattern[i] == pattern[j]) {
                next[i] = j + 1;
                j++;
                i++;
            } else if (j == 0) {
                next[i] = 0;
                i++;
            } else {
                j = next[j - 1];
            }
        }

        //检查有没有子串
        char[] schar = ss.toCharArray();
        int m = 0;//原s
        int n = 0;//匹配的
        while (m < ss.length() && n < s.length()) {
            if (schar[m] == pattern[n]) {
                m++;
                n++;
            } else if (n == 0) {
                m++;
            } else {
                n = next[n - 1];
            }

        }
        return n == s.length();

    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("sbsb"));

    }


}
