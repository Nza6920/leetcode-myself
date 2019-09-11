package leet20190911;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 false 。
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 递归函数, 以当前节点为根的树的高度
     * @param root 根节点
     * @return
     */
    private int height(TreeNode root) {
        // 空节点层数是 0
        if(root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            // 向上迭代 层数加一
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }

    private int height2(TreeNode root) {
        if (root == null)
            return 0;
        int hl = height2(root.left);
        int hr = height2(root.right);
        return Math.max(hl, hr) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        System.out.println(new Solution().height2(node));
    }
}
