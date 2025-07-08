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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfsSum(root, maxSum);
        return maxSum[0];
    }
    private int dfsSum(TreeNode root, int[] maxSum){
        if(root == null){
            return 0;
        }
        int leftPart = Math.max(0, dfsSum(root.left, maxSum));
        int rightPart = Math.max(0, dfsSum(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftPart + rightPart + root.val);
        return Math.max(leftPart , rightPart) + root.val;
    }
}