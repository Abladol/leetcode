package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串 s，找到 s 中最长的 最长回文子串。
 * <p>
 * Last Modified:
 * @date 2025/10/12 19:50
 */
public class _05_LongestPalindrome {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int maxLeft = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i-1;
            int right = i+1;
            int len = 1;
            //向左扩散,找到与i相同的
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            //向右扩散，找到与i相同的
            while (right < s.length()  && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            //两边扩散
            while (left >= 0 && right < s.length()  && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len += 2;
            }
            if (maxLen < len) {
                maxLen = len;
                maxLeft = left +1;
            }
        }

        return s.substring(maxLeft, maxLeft + maxLen);

    }

    public static void main(String[] args) {
        _05_LongestPalindrome longestPalindrome = new _05_LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("bb"));
    }
}

