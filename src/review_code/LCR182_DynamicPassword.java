package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 动态口令,某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 * 设定一个正整数目标值 target 将 password 前 target 个字符按原顺序移动至字符串末尾 请返回更新后的密码字符串。
 * <p>
 * Last Modified:
 * @date 2025/10/15 21:01
 */
public class LCR182_DynamicPassword {
    public String dynamicPassword(String password, int target) {
        StringBuilder res = new StringBuilder();
        res.append(password, target, password.length());
        res.append(password, 0, target);
        return res.toString();
    }

    public static void main(String[] args) {
        LCR182_DynamicPassword dynamicPassword = new LCR182_DynamicPassword();
        System.out.println(dynamicPassword.dynamicPassword("s3cur1tyC0d3", 4));
    }
}

