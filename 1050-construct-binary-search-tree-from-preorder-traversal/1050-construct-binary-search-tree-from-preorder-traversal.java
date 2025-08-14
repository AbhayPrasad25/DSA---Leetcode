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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            root = bst(root, preorder[i]);
        }
        return root;
    }
    public static TreeNode bst(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            root.right = bst(root.right, val);
        }
        else{
            root.left = bst(root.left, val);
        }
        return root;
    }
}