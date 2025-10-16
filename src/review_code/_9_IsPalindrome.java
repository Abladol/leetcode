package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 回文数,给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。  例如，121 是回文，而 123 不是。
 * <p>
 * Last Modified:
 * @date 2025/10/15 20:12
 */
public class _9_IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        _9_IsPalindrome isPalindrome = new _9_IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(0));
    }
}

