/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Converting the tree into string by doing level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp == null){
                str.append("x").append(",");
                continue;
            }
            str.append(Integer.toString(temp.val)).append(",");
            q.offer(temp.left);
            q.offer(temp.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> node  = new LinkedList<>();
        String[] tokens = data.split(",");
        for(String token : tokens){
            node.offer(token);
        }
        if(node.isEmpty() || node.peek().equals("x")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(node.poll()));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            
            String leftVal = node.poll();
            if(!leftVal.equals("x")){
                parent.left = new TreeNode(Integer.valueOf(leftVal));
                q.offer(parent.left);
            }
            String rightVal = node.poll();
            if(!rightVal.equals("x")){
                parent.right = new TreeNode(Integer.valueOf(rightVal));
                q.offer(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));