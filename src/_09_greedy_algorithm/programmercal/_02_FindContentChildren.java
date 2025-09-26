package _09_greedy_algorithm.programmercal;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class _02_FindContentChildren {
    //g是胃口，s是饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = 0;
        int count = 0;
        for (int i = 0; i < g.length && si < s.length; i++) {
            if (g[i] <= s[si]) {
                count++;
            } else {
                i--;
            }
            si++;
        }
        return count;
    }

    public static void main(String[] args) {
        _02_FindContentChildren findContentChildren = new _02_FindContentChildren();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        System.out.println(findContentChildren.findContentChildren(g, s));
    }
}
