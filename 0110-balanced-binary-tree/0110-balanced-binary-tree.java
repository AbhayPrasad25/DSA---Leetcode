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
    public boolean isBalanced(TreeNode root) {
        return (checkBalance(root) != -1 ? true : false);
    }
    private int checkBalance(TreeNode root){
        if(root == null){
            return 0;
        }
        //Traverse until the left most node is null
        //Used the post order traveral approach
        int leftHeight = checkBalance(root.left);
        //Traverse until the rightmost node is null
        int rightHeight = checkBalance(root.right);
        //check if the leftHeight is -1 or rightHeight is -1 and early return
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        //check for the dif if the diff is greater than 1 return -1
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        //Now return the height of each child node to the parent node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}