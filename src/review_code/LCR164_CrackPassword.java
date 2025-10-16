package review_code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 破解闯关密码,闯关游戏需要破解一组密码，闯关组给出的有关密码的线索是：  一个拥有密码所有元素的非负整数数组 password 密码是 password 中所有元素拼接后得到的最小的一个数 请编写一个程序返回这个密码。
 * <p>
 * Last Modified:
 * @date 2025/10/16 19:44
 */
public class LCR164_CrackPassword {
    public String crackPassword(int[] password) {
        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = Integer.toString(password[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LCR164_CrackPassword crackPassword = new LCR164_CrackPassword();
        System.out.println(crackPassword.crackPassword(new int[]{0, 301, 3, 5, 34, 9}));
    }
}

