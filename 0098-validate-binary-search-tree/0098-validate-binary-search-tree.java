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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stck = new Stack<>();
        //using inorder traversal 
        TreeNode prev = null;
        TreeNode temp = root;
        while(temp != null || !stck.isEmpty()){
            while(temp != null){
                stck.push(temp);
                temp = temp.left;
            }
            temp = stck.pop();
            if(prev != null && temp.val <= prev.val){
                return false;
            }
            prev = temp;
            temp = temp.right;
        }
        return true;
    }
}