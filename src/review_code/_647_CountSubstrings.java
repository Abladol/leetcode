package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 回文子串,给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。  子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * Last Modified:
 * @date 2025/10/14 21:09
 */
public class _647_CountSubstrings {

    public int countSubstrings(String s) {
        //中心扩散法，找到中心，中心数是s长度的2倍-1
        int res = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _647_CountSubstrings countSubstrings = new _647_CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }
}

