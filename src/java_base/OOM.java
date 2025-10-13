package java_base;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 多线程oom
 * <p>
 * Last Modified:
 * @date 2025/9/21 14:56
 */
public class OOM {

        public String removeKDigits(String num, int k) {
            if (k >= num.length()) {
                return "0";
            }

            StringBuilder stack = new StringBuilder();
            for (char digit : num.toCharArray()) {
                while (k > 0 && stack.length() > 0 && digit < stack.charAt(stack.length() - 1)) {
                    stack.deleteCharAt(stack.length() - 1);
                    k--;
                }
                stack.append(digit);
            }

            // 如果还有k剩余，则从末尾删除k个字符
            if (k > 0) {
                stack.setLength(stack.length() - k);
            }

            // 移除前导零
            int start = 0;
            while (start < stack.length() && stack.charAt(start) == '0') {
                start++;
            }
            String result = stack.substring(start);
            return result.isEmpty() ? "0" : result;
        }
}

