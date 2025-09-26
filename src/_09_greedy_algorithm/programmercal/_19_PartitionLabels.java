package _09_greedy_algorithm.programmercal;

import java.util.*;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 */
public class _19_PartitionLabels {
    //我的答案
    public List<Integer> partitionLabels(String s) {
        List<Integer> labels = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] charMap = new int[26];
        HashSet<Character> hashSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            charMap[chars[i] - 97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            count++;
            hashSet.add(chars[i]);
            charMap[chars[i] - 97]--;
            if (charMap[chars[i] - 97] == 0) {
                hashSet.remove(chars[i]);
            }
            //hashset为空说明找到一组
            if (hashSet.isEmpty()) {
                labels.add(count);
                count = 0;
            }
        }
        return labels;
    }

    //标准答案：记录每个字母最远的位置这之间如果其余字母最远的位置小于这个值，那么这个区间就是满足的
    public List<Integer> partitionLabels1(String s) {
        List<Integer> labels = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] charIndex = new int[26];
        //找到每个字母最远的位置
        for (int i = 0; i < chars.length; i++) {
            charIndex[chars[i] - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        //使用双指针法来判断
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, charIndex[chars[i] - 'a']);
            if (i == right) {
                labels.add(right - left + 1);
                left = i+1;
            }

        }
        return labels;
    }


    public static void main(String[] args) {
        _19_PartitionLabels partitionLabels = new _19_PartitionLabels();
        List<Integer> list = partitionLabels.partitionLabels1("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
