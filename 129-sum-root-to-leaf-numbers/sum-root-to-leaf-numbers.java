/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int current_sum) {
        if (node == null) return 0;
        current_sum = current_sum * 10 + node.val;
        if (node.left == null && node.right == null) return current_sum;
        return sum(node.left, current_sum) + sum(node.right, current_sum);
    }
}
