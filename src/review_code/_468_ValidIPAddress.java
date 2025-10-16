package review_code;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 验证IP地址,给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
 * 例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:  1 <= xi.length <= 4 xi 是一个 十六进制字符串 ，
 * 可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
 * 而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 * <p>
 * Last Modified:
 * @date 2025/10/14 17:22
 */
public class _468_ValidIPAddress {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            String[] subs = queryIP.split("\\.", -1);
            if (subs.length != 4) {
                return "Neither";
            }
            for (int i = 0; i < subs.length; i++) {
                if (subs[i].length() > 3) {
                    return "Neither";
                }
                for (int j = 0; j < subs[i].length(); j++) {
                    if (!Character.isDigit(subs[i].charAt(j))) {
                        return "Neither";
                    }
                }
                if (subs[i].isEmpty() || Integer.parseInt(subs[i]) > 255 || Integer.parseInt(subs[i]) < 0) {
                    return "Neither";
                }
                if (subs[i].length() > 1 && subs[i].charAt(0) == '0') {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (queryIP.contains(":")) {
            String[] subs = queryIP.split(":", -1);
            if (subs.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < subs.length; i++) {
                if (subs[i].isEmpty() || subs[i].length() > 4) {
                    return "Neither";
                }
                for (int j = 0; j < subs[i].length(); j++) {
                    if ((!Character.isDigit(subs[i].charAt(j)) &&
                            !(Character.toLowerCase(subs[i].charAt(j)) >= 'a' && Character.toLowerCase(subs[i].charAt(j)) <= 'f'))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {
        _468_ValidIPAddress validIPAddress = new _468_ValidIPAddress();
        System.out.println(validIPAddress.validIPAddress("1.1.1."));
    }
}

