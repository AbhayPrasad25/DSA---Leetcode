/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> Parentmap = new HashMap<>();
        q.add(root);
        //iterate and make a parent child realtionship
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
                Parentmap.put(node.left, node);
            }
            if(node.right != null){
                q.add(node.right);
                Parentmap.put(node.right, node);
            }
        }

        //now we need to do bfs traversal on all three direction of a node and keep track of visited nodes
        HashSet<TreeNode> visited = new HashSet<>();
        //start iteration from the tagetNode as it has beem given
        q.add(target);
        visited.add(target);
        int curDistance = 0;
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            if(curDistance == k){
                while(!q.isEmpty()){
                    result.add(q.poll().val);
                }
                return result;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                //left
                if(node.left != null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                //right
                if(node.right != null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                //parent
                if(Parentmap.containsKey(node) && !visited.contains(Parentmap.get(node))){
                    q.add(Parentmap.get(node));
                    visited.add(Parentmap.get(node));
                }
            }
            curDistance++;
        }
        return result;
    }
}