package _09_greedy_algorithm.programmercal;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 */

/**
 * 从题目中示例，其实可以得到启发，我们发现题目示例中的摄像头都没有放在叶子节点上！
 * 这是很重要的一个线索，摄像头可以覆盖上中下三层，如果把摄像头放在叶子节点上，就浪费的一层的覆盖。
 * 所以把摄像头放在叶子节点的父节点位置，才能充分利用摄像头的覆盖面积。
 * 那么有同学可能问了，为什么不从头结点开始看起呢，为啥要从叶子节点看呢？
 * 因为头结点放不放摄像头也就省下一个摄像头， 叶子节点放不放摄像头省下了的摄像头数量是指数阶别的。
 * 所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
 * 局部最优推出全局最优，找不出反例，那么就按照贪心来！
 * 此时，大体思路就是从低到上，先给叶子节点父节点放个摄像头，然后隔两个节点放一个摄像头，直至到二叉树头结点。
 * 此时这道题目还有两个难点：
 * 二叉树的遍历
 * 如何隔两个节点放一个摄像头
 */
public class _23_MinCameraCover {
    private int result = 0;

    public int minCameraCover(TreeNode root) {
        int rootval = travalTree(root);
        //情况四；如果根节点没有被覆盖，那么直接安装摄像头
        if (rootval == 0) {
            result++;
        }
        return result;
    }

    /*该程序遍历树，并判断是否需要安装摄像头，采用后序遍历，左右中
     * 0：没有覆盖
     * 1：被覆盖
     * 2：安装摄像头
     * */
    public int travalTree(TreeNode root) {
        //终止条件，空就是被覆盖
        if (root == null) {
            return 1;
        }
        //从叶子节点开始
        int left = travalTree(root.left);
        int right = travalTree(root.right);
        //情况一：如果两个子节点都被覆盖，那么该节点就是没有被覆盖，让其父节点安装摄像头
        if (left == 1 && right == 1) {
            return 0;
        }
        //情况二：如果两个子节点有一个没有被覆盖，那么该节点安装摄像头
        if (left == 0 || right == 0) {
            result += 1;
            return 2;
        }
        //情况三：如果两个子节点有一个有摄像头，那么该节点就是被覆盖
        if (left == 2 || right == 2) {
            return 1;
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        _23_MinCameraCover minCameraCover = new _23_MinCameraCover();
//                   1
//                  / \
//                 2   3
//                / \   \
//               4   5   6
        // 创建根节点
        TreeNode root = new TreeNode(1);

        // 创建左子树
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        // 创建右子树
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        node3.left = node6;

        // 将左右子树连接到根节点
        root.left = node2;
        root.right = node3;
        System.out.println(minCameraCover.minCameraCover(root));
    }
}
