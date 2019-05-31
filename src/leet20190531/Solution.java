package leet20190531;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution {
    /**
     * 队列 + 迭代
     * @param root 根节点
     * @return List
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return tree;

        int curlevel = 1;
        queue.offer(root);
        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node.val);
            curlevel--;

            if (node.left != null) queue.add(node.left);
            if (node.right != null)  queue.add(node.right);

            if (curlevel == 0) {
                curlevel = queue.size();
                tree.add(0, nodes);
                nodes = new ArrayList<>();
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(7);

        List<List<Integer>> tree = levelOrderBottom(treeNode);

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
