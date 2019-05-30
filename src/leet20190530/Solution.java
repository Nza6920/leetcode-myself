package leet20190530;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 */
public class Solution {
    /**
     * 递归
     * @param root 二叉树
     * @return int
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int deep = Math.max(maxDepth(root.left), maxDepth(root.right));

        return deep + 1;
    }

    /**
     * 迭代遍历
     * @param root 二叉树
     * @return int
     */
    public static int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;

        queue.offer(root);
        int curLevel = queue.size();
        int deep = 0;

        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();
            curLevel--;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            if (curLevel == 0) {
                curLevel = queue.size();
                deep++;
            }
        }
        return deep;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(7);

        int deep = maxDepth(treeNode);
        int deep2 = maxDepth2(treeNode);

        System.out.println("finish :)");
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
