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
    int node;
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return node;
    }
    public void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inorder(root.left, k);
        i++;
        if(i == k){
            node = root.val;
            return;
        }
        inorder(root.right, k);
    }
}