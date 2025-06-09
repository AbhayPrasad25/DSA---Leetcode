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
        List<String> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        paths(root, res, ans);
        return res;
    }
    private void paths(TreeNode root, List<String> res, List<String> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(Integer.toString(root.val));
            res.add(String.join("->", ans));
            ans.remove(ans.size() - 1);
            return;
        }
        ans.add(Integer.toString(root.val));
        paths(root.left, res, ans);
        paths(root.right, res, ans);
        ans.remove(ans.size()- 1);
    }
}