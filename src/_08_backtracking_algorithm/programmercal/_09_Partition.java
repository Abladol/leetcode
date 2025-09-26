package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class _09_Partition {
    private List<List<String>> res = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrace(s,0);
        return res;
    }

    public void backTrace(String s,int startIndex){
        //回溯终止条件
        if (startIndex==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //判断是否是回文字符串
            if (isPartionString(s.substring(startIndex,i+1))) {
                temp.add(s.substring(startIndex, i+1));
            }else {
                continue;

            }
            backTrace(s, i + 1);
            //上一步的结果清除
            temp.remove(temp.size() - 1);
        }

    }

    //判断是否是回文字符串
    public  boolean isPartionString(String s){
        char[] chars = s.toCharArray();;
        int last = s.length()-1;
        for (int first = 0; first <= last; first++,last--) {
            if(chars[first]!=chars[last]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _09_Partition partition = new _09_Partition();
        System.out.println(Arrays.toString(partition.partition("aaaaa").toArray()));


    }
}
