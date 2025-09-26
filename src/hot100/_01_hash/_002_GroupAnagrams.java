package hot100._01_hash;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。  、
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * Last Modified:
 * @date 2024/12/10 10:21
 */
public class _002_GroupAnagrams {
    /*
    思路1：对于字母异位词，如果将词的字母按照顺序进行重新排序，他们的结构都是一样的，可以使用hash表存储起来
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            byte[] sBytes = s.getBytes();
            Arrays.sort(sBytes);
            String newStr= new String(sBytes);
           if(map.containsKey(newStr)){
               map.get(newStr).add(strs[i]);
           }else {
               ArrayList<String> list = new ArrayList<>();
               list.add(strs[i]);
               map.put(newStr,list);
           }
        }
        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }

    public static void main(String[] args) {
        _002_GroupAnagrams groupAnagrams = new _002_GroupAnagrams();
        List<List<String>> list = groupAnagrams.groupAnagrams(new String[]{"sta", "ats", "afr"});
        for (List<String> strings : list) {
            System.out.println(Arrays.toString(strings.toArray()));
        }
    }
}

