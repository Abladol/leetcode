package review_code;

import javax.management.MBeanAttributeInfo;
import java.util.HashSet;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 招式拆解 I,某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式。
 * <p>
 * Last Modified:
 * @date 2025/10/13 15:49
 */
public class _167_DismantlingAction {
    public int dismantlingAction(String arr) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        char[] chs = arr.toCharArray();
        int len = 0;
        int res = 0;
        while (left <= right && right < chs.length) {
            if (set.contains(chs[right])) {
                while (left <= right && set.contains(chs[right])) {
                    set.remove(chs[left]);
                    left++;
                    len--;
                }
            } else {
                set.add(chs[right]);
                right++;
                len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _167_DismantlingAction dismantlingAction = new _167_DismantlingAction();
        System.out.println(dismantlingAction.dismantlingAction("pwwkew"));
    }


}

