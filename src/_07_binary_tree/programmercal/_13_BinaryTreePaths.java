package _07_binary_tree.programmercal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。  说明: 叶子节点是指没有子节点的节点。
 * <p>
 * Last Modified:
 * @date 2024/11/11 14:38
 */
public class _13_BinaryTreePaths {
    private  final List<List<Integer>> paths = new ArrayList<>();

    public  List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> strPaths = new ArrayList<>();
        traverse(root, path);
        for (List<Integer> intPath : paths) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < intPath.size() - 1; i++) {
                s.append(intPath.get(i).toString());
                s.append("->");
            }
            s.append(intPath.get(intPath.size()-1).toString());
            strPaths.add(s.toString());
        }
        return strPaths;
    }

    //前序遍历
    public  List<Integer> traverse(TreeNode root, List<Integer> path) {
        if (root == null) {
            return null;
        }
        path.add(root.val);
        traverse(root.left, path);
        traverse(root.right, path);
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);
        return path;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n4 = new TreeNode(4, n6, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(new _13_BinaryTreePaths().binaryTreePaths(n7));
    }
}

