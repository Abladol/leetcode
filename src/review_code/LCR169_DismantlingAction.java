package review_code;

import javax.management.MBeanAttributeInfo;
import java.util.*;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description:招式拆解 II, 某套连招动作记作仅由小写字母组成的序列 arr，其中 arr[i] 第 i 个招式的名字。请返回第一个只出现一次的招式名称，如不存在请返回空格。
 * <p>
 * Last Modified:
 * @date 2025/10/13 16:07
 */
public class LCR169_DismantlingAction {
    public char dismantlingAction(String arr) {
        List<Character> list = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length(); i++) {
            if (!set.contains(arr.charAt(i))) {
                set.add(arr.charAt(i));
                list.add(arr.charAt(i));
            } else {
                list.remove(Character.valueOf(arr.charAt(i)));
            }
        }
        if (list.isEmpty()) {
            return ' ';
        } else {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        LCR169_DismantlingAction dismantlingAction = new LCR169_DismantlingAction();
        System.out.println(dismantlingAction.dismantlingAction("ccdd"));

    }
}

