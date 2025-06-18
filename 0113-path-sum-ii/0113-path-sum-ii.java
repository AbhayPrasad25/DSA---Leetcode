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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backtrack(root, targetSum, 0, res, ans);
        return res;
    }
    public void backtrack(TreeNode root, int targetSum, int sum, List<List<Integer>> res, List<Integer> ans){
        if(root == null){
            return;
        }
        if(sum + root.val == targetSum && root.left == null && root.right == null){
            ans.add(root.val);
            res.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
            return;
        }
        ans.add(root.val);
        backtrack(root.left, targetSum, sum + root.val, res, ans);
        backtrack(root.right, targetSum, sum + root.val, res, ans);
        ans.remove(ans.size() - 1);
    }
}