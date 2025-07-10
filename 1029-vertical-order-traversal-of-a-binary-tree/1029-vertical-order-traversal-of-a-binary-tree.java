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
    class Tuple{
        TreeNode root;
        int x;
        int y;
        Tuple(TreeNode root, int x , int y){
            this.x = x;
            this.y = y;
            this.root = root;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //Map to store the column based pairs
        List<List<Integer>> ans = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue <Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple block = q.poll();
            TreeNode temp = block.root;
            int col = block.x;
            int row = block.y;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row , new PriorityQueue<>());
            map.get(col).get(row).offer(temp.val);

            //the same level order traversal
            if(temp.left != null){
                q.offer(new Tuple(temp.left, col - 1, row + 1));
            }
            if(temp.right != null){
                q.offer(new Tuple(temp.right, col + 1, row + 1));
            }
        }
        //iteration to fill the list 
        for(TreeMap<Integer, PriorityQueue<Integer>> ymap : map.values()){
            List<Integer> res = new LinkedList<>();
            for(PriorityQueue<Integer> vals : ymap.values()){
                while(!vals.isEmpty()){
                    res.add(vals.poll());
                }
            }
            ans.add(res);
        }
        return ans;
    }
}