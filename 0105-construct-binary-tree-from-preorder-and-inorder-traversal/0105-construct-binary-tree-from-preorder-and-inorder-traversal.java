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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i] , i);
        }
        return createTree(preorder, map, 0, 0, inorder.length);
    }
    public TreeNode createTree(int[] preorder, HashMap<Integer, Integer> map, int pStart, int iStart, int size){
        if(size <= 0){
            return null;
        }
        int rootNode = preorder[pStart];
        int inorderIndex = map.get(rootNode);
        int leftSize = inorderIndex - iStart;

        TreeNode left = createTree(preorder, map, pStart + 1, iStart, leftSize);
        TreeNode right = createTree(preorder , map, pStart + 1 + leftSize, inorderIndex + 1, size - 1 -leftSize);
        return new TreeNode(rootNode, left, right);
    }
}