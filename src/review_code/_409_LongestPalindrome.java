package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 最长回文串,给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * Last Modified:
 * @date 2025/10/14 20:23
 */
public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] chs = new char[52];
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                chs[c - 'A' + 26]++;
            } else {
                chs[c - 'a']++;
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] % 2 == 0) {
                res += chs[i];
            } else {
                flag = true;
                res += chs[i] - 1;
            }
        }
        return flag ? res + 1 : res;
    }


    public static void main(String[] args) {
        _409_LongestPalindrome longestPalindrome = new _409_LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abcbbcca"));
    }

}

