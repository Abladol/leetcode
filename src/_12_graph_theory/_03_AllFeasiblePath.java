package _12_graph_theory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author AiJun
 * @version 1.0
 * <p>
 * Description: 给定一个有 n 个节点的有向无环图，节点编号从 1 到 n。请编写一个函数，找出并返回所有从节点 1 到节点 n 的路径。
 * 每条路径应以节点编号的列表形式表示。
 * 输入描述：
 * 第一行包含两个整数 N，M，表示图中拥有 N 个节点，M 条边
 * 后续 M 行，每行包含两个整数 s 和 t，表示图中的 s 节点与 t 节点中有一条路径
 * 输出描述：
 * 输出所有的可达路径，路径中所有节点之间空格隔开，每条路径独占一行，存在多条路径，路径输出的顺序可任意。如果不存在任何一条路径，则输出 -1。
 * 注意输出的序列中，最后一个节点后面没有空格！ 例如正确的答案是 `1 3 5`,而不是 `1 3 5 `， 5后面没有空格！
 * <p>
 * Last Modified:
 * @date 2024/12/10 14:51
 */
public class _03_AllFeasiblePath {

    private static int nodeNum;
    private static List<Integer> temp = new ArrayList<>();
    private static List<List<Integer>> res = new ArrayList<>();
    private static int[][] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        nodeNum = scanner.nextInt();
        int arcNum = scanner.nextInt();
        path = new int[nodeNum][nodeNum];
        for (int i = 0; i < arcNum; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            path[n1 - 1][n2 - 1] = 1;
        }
        retrace(1);
        if(res.isEmpty()){
            System.out.println(-1);
        }
        for (List<Integer> r : res) {
            for (int i = 0; i < r.size()-1; i++) {
                System.out.print(r.get(i).toString()+' ');
            }
            System.out.println(r.get(r.size()-1).toString());
        }
    }

    public static void retrace(int node) {
        //找到了一条路径
        if (node == nodeNum) {
            temp.add(node);
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(node);
        for (int i = 0; i < nodeNum; i++) {
            if (path[node - 1][i] == 1) {
                retrace(i + 1);
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }
}

