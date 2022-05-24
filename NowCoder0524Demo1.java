import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 124. 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 示例1
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 示例2
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class NowCoder0524Demo1 {
    private static int ans = Integer.MIN_VALUE;
    private static int index = 0;;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rootStr = sc.next();
        String[] rootArray = rootStr.split(",");
        if (rootArray == null || rootArray.length == 0 || "null".equals(rootArray[0])) {
            System.out.println(0);
            return ;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootArray[index++]));
        restoreBinaryTree(root, rootArray);
        System.out.println(maxPathSum(root));
    }

    /**
     * 加载完全二叉树
     * @param root
     * @param treeList
     */
    public static void restoreBinaryTree(TreeNode root, String[] treeList) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                TreeNode left = getNode(treeList);
                if (left != null) {
                    node.left = left;
                    queue.offer(left);
                }
                TreeNode right = getNode(treeList);
                if (right != null) {
                    node.right = right;
                    queue.offer(right);
                }

            }
        }
    }

    public static TreeNode getNode(String[] treeList) {
        int i = index++;
        if (i >= treeList.length) {
            return null;
        }
        String val = treeList[i];
        return "null".equals(val) ? null : new TreeNode(Integer.valueOf(val));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        oneSideMax(root);
        return ans;
    }

    public static int oneSideMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, oneSideMax(node.left));
        int right = Math.max(0, oneSideMax(node.right));
        ans = Math.max(ans, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
