package hot100._04_substring;

import java.util.HashMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * Last Modified:
 * @date 2025/1/2 9:10
 */
public class _012_MinWindow {
    /*
    我的思路：本题属于困难题，我的思路都是基于暴力算法的优化，如果是暴力算法实际上就是一个一个遍历，我们可以进行一步小的优化，例如DASHBDCFG,需要搜索ABC，
             一开始搜索的时候最先满足条件的是ASHBDC,那么这时候，我们可以第一个指针后移这个时候不满足条件的，那么我们就继续让右指针移动直到满足条件，如果此时是满足条件的
            就继续右移左边的指针，不断缩小这搜索窗口
     */
    public String minWindow(String s, String t) {
        String res = "";
        int resLength = Integer.MAX_VALUE;
        //先使用map来存储t中的所有字符
        char[] tt = t.toCharArray();
        char[] ss = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tt) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        //处理
        int i = 0;
        for (int j = 0; j < ss.length; j++) {
            if (map.containsKey(ss[j])) {
                map.put(ss[j], map.get(ss[j]) - 1);
            }
            //map里面的值如果全是小于等于0说明找到了这样一个窗口，为什么不是等于0呢，假设s为AAABBBCC,t为ABC，这样会出现map有负值，就永远无法满足，其实是负值也没事，
            //因为我们需要的是他存在
            while (map.values().stream().allMatch(x -> x <= 0)) {
                //临时的结果
                String temp = s.substring(i, j + 1);
                if (resLength > temp.length()) {
                    res = temp;
                    resLength = res.length();
                }
                //左指针右移，缩小窗口
                if (map.containsKey(ss[i])) {
                    map.put(ss[i], map.get(ss[i]) + 1);
                }
                i++;
            }
        }
        return res;
    }

    //标准答案：思路其实差不多，判断的代码时间复杂度以及空间复杂度更低,没有使用hashmap而是使用数组就可以
    public String minWindow2(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[s[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[s[left]]--; // 左端点字母移出子串
                left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _012_MinWindow minWindow = new _012_MinWindow();
        System.out.println(minWindow.minWindow("AAAABBBBBC", "ABC"));
    }
}

