package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 验证回文串 II,给你一个字符串 s，最多 可以从中删除一个字符。  请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * Last Modified:
 * @date 2025/10/12 20:18
 */
public class _680_ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean flag = true;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return valid(s, left + 1, right) || valid(s, left, right - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean valid(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _680_ValidPalindrome validPalindrome = new _680_ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("cbbcc"));

    }
}

