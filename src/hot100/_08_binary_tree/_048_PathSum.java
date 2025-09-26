package hot100._08_binary_tree;

import hot100.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * Last Modified:
 * @date 2025/2/12 15:27
 */
public class _048_PathSum {
    /*
    个人思路：使用回溯算法，因为节点值有正有负，所以要一直搜索到叶子节点
     */
    int res = 0;
    long sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        sum = 0;
        if (root == null) {
            return 0;
        }
        retrace(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void retrace(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) res++;
        retrace(root.left, targetSum);
        retrace(root.right, targetSum);
        //走到这一步，说明左右子树都搜索完毕还是不行，就退回上一层
        sum -= root.val;
        return;
    }

    /*
    自己思路可行，但是效率极低，主要存在重复操作，例如，ab，abc，abcd求这三个路径和，实际上我们也隐含的求出了cd的路径和，abcd-ab即可，这样就不需要再从c开始遍历了
    所以要使用前缀和的方法来解决问题
     */
    Map<Long, Integer> map = new HashMap<>();

    {
        //空路径的前缀和
        map.put(0L, 1);
    }

//    long sum = 0;
//    int res = 0;

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        //判断map中有无sum-target值,没有存0，就是从头到尾直接符合，多判断一次
        if (map.containsKey(sum - targetSum)) res += map.get(sum - targetSum);
//        if (sum == targetSum) res++;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        pathSum2(root.left, targetSum);
        pathSum2(root.right, targetSum);
        //清除map对应节点的前缀
        map.put(sum, map.get(sum) - 1);
        sum -= root.val;
        return res;
    }


    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t4 = new TreeNode(4, t3, t6);
        TreeNode t1 = new TreeNode(1);
        TreeNode t5 = new TreeNode(5, t1, t4);

        _048_PathSum pathSum = new _048_PathSum();
        System.out.println(pathSum.pathSum2(t5, 6));
    }


}

