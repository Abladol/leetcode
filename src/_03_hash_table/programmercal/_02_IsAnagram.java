package _03_hash_table.programmercal;

/**
 * 有效的字母异位词：
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class _02_IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("ababs","bbaqas"));

    }

    /**
     * 思路：从另一个角度考虑，ttt 是 sss 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。由于字符串只包含 262626 个小写字母，
     * 因此我们可以维护一个长度为 262626 的频次数组 table\textit{table}table，先遍历记录字符串 sss 中字符出现的频次，然后遍历字符串
     * ttt，减去 table\textit{table}table 中对应的频次，如果出现 table[i]<0\textit{table}[i]<0table[i]<0，则说明 ttt 包含一个不在
     * sss 中的额外字符，返回 false\text{false}false 即可。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            records[t.charAt(i) - 'a']--;
        }
        for (int record :
                records) {
            if (record != 0) {
                return false;
            }
        }
        return true;
    }
}
