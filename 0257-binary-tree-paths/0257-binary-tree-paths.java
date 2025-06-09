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
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();
        paths(root, res, str);
        return res;
    }
    private void paths(TreeNode root, List<String> res, StringBuilder str){
        if(root == null){
            return;
        }
        int len = str.length();
        str.append(root.val);
        if(root.left == null && root.right == null){
            res.add(str.toString());
        }
        else{
            str.append("->");
            paths(root.left, res, str);
            paths(root.right, res, str);
        }
        str.setLength(len);
    }
}