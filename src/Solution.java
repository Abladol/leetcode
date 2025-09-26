public class Solution {
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

        // 如果还有 k 剩余，则从末尾删除 k 个字符
        String ans = "";
        if (k > 0) {
            ans = stack.substring(0, stack.length() - k);
        }

        // 移除前导零

//        String result = stack.substring(start);
        return ans.isEmpty() ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        int bb=0;
       try {
           bb=1;
           int a = 1/0;
           bb=2;
       }catch (Exception e){
           bb=3;
           System.out.println(bb);
       }
       finally {
           bb=4;
           System.out.println(bb);
       }
    }
}