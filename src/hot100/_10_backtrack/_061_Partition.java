package hot100._10_backtrack;

import example.java8_function_interface.Sout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * Last Modified:
 * @date 2025/2/20 19:37
 */
public class _061_Partition {
    /*
    我的思路：这是一个组合，需要有顺序，所以回溯需要传入起始坐标
     */
    List<List<String>> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        retrace(s, 0);
        return res;
    }

    public void retrace(String s, int start) {
        StringBuffer sbuffer = new StringBuffer();
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //开始回溯
        for (int i = start; i < s.length(); i++) {
            sbuffer.append(s.substring(i, i + 1));
            boolean flag = isOK(sbuffer);
            if (flag) {
                temp.add(sbuffer.toString());
                retrace(s, i + 1);
                //这个时候回到哪儿，直接回到上一层
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isOK(StringBuffer s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _061_Partition partition = new _061_Partition();
        List<List<String>> lists = partition.partition("abcbcdddfd");
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

