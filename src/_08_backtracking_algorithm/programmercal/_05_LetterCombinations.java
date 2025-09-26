package _08_backtracking_algorithm.programmercal;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class _05_LetterCombinations {
    private List<List<Character>> res = new ArrayList<>();

    private List<Character> temp = new ArrayList<>();

    private String[] num2char = new String[]{
            "", //0
            "", //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9

    };

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){return Collections.emptyList();}
        char[] nums = digits.toCharArray();
        backTrace(nums,0);
        return res.stream().map(x->x.stream().map(Objects::toString).collect(Collectors.joining())).toList();
    }

    //index是第几个电话号码
    public void backTrace(char[] nums, int index) {

        //终止条件
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }


        if(index>=nums.length){return;}
        int num = nums[index] - '0';

        //i是对树的横向遍历，每一个集合的char
        for (int i = 0; i < num2char[num].length(); i++) {
            temp.add(num2char[num].toCharArray()[i]);
            backTrace(nums,index+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        _05_LetterCombinations letterCombinations = new _05_LetterCombinations();
        System.out.println(Arrays.toString(letterCombinations.letterCombinations("2").toArray()));

    }

}
