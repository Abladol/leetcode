package _04_string.programmercal;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class _04_ReverseWords {
    /**
     * 自己写的方法，思路：
     * 两个指针找到单词，标志flag表示在操作单词，利用stringbuffer一直向前插入数据
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int left = 0;
        int right = 0;
        boolean flag = false;
        StringBuffer res = new StringBuffer();
        for (int curr = 0; curr < s.length(); curr++) {
            if (ss[curr] != ' ' && !flag) {
                left = curr;
                flag = true;//选中单词了
            }
            if ((curr == s.length() - 1 || ss[curr + 1] == ' ' )&& flag) {
                right = curr;
                while (right >= left) {
                    res.insert(0, ss[right]);
                    right--;
                }
                res.insert(0, ' ');
                flag = false;
            }
        }
        return res.deleteCharAt(0).toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  a   good   example"));
    }
}
