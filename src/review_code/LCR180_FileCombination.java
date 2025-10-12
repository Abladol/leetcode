package review_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。
 * 传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 * 注意，返回时需遵循以下规则：
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 * <p>
 * Last Modified:
 * @date 2025/10/12 19:36
 */
public class LCR180_FileCombination {
    public int[][] fileCombination(int target) {
        int left = 1;
        int right = 1;
        int sum = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left <= right) {
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    temp.add(i);
                }
                res.add(temp);
                sum -= left;
                left++;
            } else if (sum < target && right < target - 1) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            result[i] = list.stream().mapToInt(Integer::intValue).toArray();
        }

        return result;

    }

    public static void main(String[] args) {
        LCR180_FileCombination fileCombination = new LCR180_FileCombination();
        int[][] res = fileCombination.fileCombination(10);
        System.out.println(Arrays.deepToString(res));
    }
}

