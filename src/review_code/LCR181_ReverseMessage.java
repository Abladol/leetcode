package review_code;

import javax.management.MBeanAttributeInfo;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 字符串中的单词反转,你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，
 * 为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转换为正常语序。  注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * Last Modified:
 * @date 2025/10/15 20:32
 */
public class LCR181_ReverseMessage {
    public String reverseMessage(String message) {
        message = ' ' + message;
        StringBuilder res = new StringBuilder();
        int left = message.length() - 1;
        int right = message.length();
        while (left >= 0) {
            if (message.charAt(left) == ' ') {
                if (left + 1 == right) {
                    left--;
                    right--;
                    continue;
                }
                res.append(message, left + 1, right);
                res.append(' ');
                right = left;
                left--;
            } else {
                left--;
            }
        }
        return res.isEmpty() ? "" : res.deleteCharAt(res.length() - 1).toString();
    }

    public static void main(String[] args) {
        LCR181_ReverseMessage reverseMessage = new LCR181_ReverseMessage();
        System.out.println(reverseMessage.reverseMessage("  "));
    }
}

