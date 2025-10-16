package review_code;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 根据字符出现频率排序,给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 * Last Modified:
 * @date 2025/10/16 20:52
 */
public class _451_FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> list = map.keySet().stream().sorted(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        }).toList();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while (cnt-- > 0) {
                res.append(list.get(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _451_FrequencySort frequencySort = new _451_FrequencySort();
        System.out.println(frequencySort.frequencySort("tree"));
    }
}

