package hot100._03_sliding_window;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长  子串  的长度。
 * <p>
 * Last Modified:
 * @date 2024/12/18 14:39
 */
public class _008_LengthOfLongestSubstring {
    /**
     * 个人思路：假设一个字符串pwawke，pwq都是不重复的，当遍历到第二个w的时候，发现重复了（可以用hash表实现），我们可以找到第一个w的位置，在第二个w之前都是不重复的，
     * 第一个w之后到第二个w也是不重复的，这两点现明确，然后我的思路是从第一个w后面重新开始遍历，其实我感觉可以从第二个w后面开始遍历的，不过hash表就不好处理，
     * 因为不好删除第一个w之前出现的字母
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                res = Math.max(res, map.size());
            } else {
                int index = map.get(chars[i]);
                i = index;
                map.clear();
            }
        }
        return res;
    }

    /**
     * 标准答案，使用滑动窗口法，主要就是处理重复字符串部分，如果没有重复，窗口右端一直增大，如果出现重复字符串，窗口左端右移，窗口不断减小，直到不重复字符串，这个方法
     * 弥补了自己思路中的不足，他可以一个一个的移除元素，直到不重复字符串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            //如果set中已经存在，则说明窗口左端需要右移，直到找到那个重复的元素，窗口从他下一个元素开始
            while (set.contains(c)) {
                set.remove(chars[left]);
                left++;
            }
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static void main(String[] args) {
        _008_LengthOfLongestSubstring lengthOfLongestSubstring = new _008_LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aacb"));
    }

}

