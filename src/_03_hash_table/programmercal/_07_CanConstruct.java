package _03_hash_table.programmercal;


/**
 * 题目描述：给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class _07_CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdee","abcdefg"));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            table[magazine.charAt(i) - 'a']++;
        }
        for (char s : ransomNote.toCharArray()) {
            if (table[s - 'a'] < 1) return false;
            table[s - 'a']--;
        }
        return true;
    }


}
