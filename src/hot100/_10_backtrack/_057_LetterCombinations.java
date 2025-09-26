package hot100._10_backtrack;

import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * Last Modified:
 * @date 2025/2/16 16:59
 */
public class _057_LetterCombinations {
    String[] s = new String[]{null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    List<Character> temp = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(Objects.equals(digits, "")){
            return Collections.emptyList();
        }
        char[] charArray = digits.toCharArray();
        int[] nums = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            nums[i]=charArray[i]-'0';
        }
        retrace(nums,0);
        return res;
    }

    public void retrace(int[] nums,int k) {
        //回溯终止,纵向的
        if (temp.size() == nums.length) {
            StringBuffer sb = new StringBuffer();
            for (Character c : temp) {
                sb.append(c.toString());
            }
            res.add(sb.toString());
        }
        //横向遍历,最外层，按键有几个
        for (int i = k; i < nums.length; i++) {
            char[] digit = s[nums[i] - 1].toCharArray();
            //每一个按键都要依次遍历，从这开始才是我们熟悉的回溯
            for (int j = 0; j < digit.length; j++) {
                temp.add(digit[j]);
                //第二个参数就是标记我们在第几层
                retrace(nums,i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
        _057_LetterCombinations letterCombinations = new _057_LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("");
        System.out.println(Arrays.toString(list.toArray()));
    }
}

