package _08_backtracking_algorithm.programmercal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排
 * 序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class _10_RestoreIpAddresses {
    public List<String> res = new ArrayList<>();

    private List<String> temp = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrace(s, 0);
        return res;

    }

    public void backTrace(String s, int startIndex) {
        //回溯终止条件
        if (startIndex == s.length() && temp.size() == 4) {
            res.add(temp.stream().collect(Collectors.joining(".")));
            return;
        }
        if (temp.size() >= 4) {
            return;
        }
        for (int i = startIndex; i < s.length() && i - startIndex <= 4; i++) {
            if (isIleageAddrs(s.substring(startIndex, i + 1))) {
                temp.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTrace(s, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


    //判断地址是否合法，必须在0-225范围内，022这种属于不合法
    public boolean isIleageAddrs(String s) {
        if (Integer.parseInt(s) > 255) {
            return false;
        } else if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _10_RestoreIpAddresses restoreIpAddresses = new _10_RestoreIpAddresses();
        System.out.println(Arrays.toString(restoreIpAddresses.restoreIpAddresses("0000").toArray()));
    }

}
