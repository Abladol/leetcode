package _04_string.programmercal;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 * <p>
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 * <p>
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

/*
标准
 */
public class _06_StrStr {
    public static int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (needle.isEmpty()) {
            return 0;
        }
        int[] next = kmpNext(needle);
        int i = 0;//原字符串
        int j = 0;//匹配的字符串
        while (i < h.length || j == next.length) {
            //匹配到了
            if (j == next.length) {
                return i - j;
            } else if (h[i] == n[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }

        }
        return -1;
    }

    public static int[] kmpNext(String s) {
        int length = s.length();
        char[] pattern = s.toCharArray();
        int i = 1;
        int j = 0;
        int[] next = new int[length];
        next[0] = 0;
        while (i < length) {
            if (pattern[i] == pattern[j]) {
                next[i] = j + 1;
                j++;
                i++;
                continue;
            }
            if (j == 0) {
                next[i] = 0;
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
