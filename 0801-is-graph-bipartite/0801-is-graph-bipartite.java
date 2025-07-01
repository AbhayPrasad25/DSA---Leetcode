class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(bfs(i, graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node, int[][] graph, int[] color){
        color[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int Node = q.poll();
            for(int adjNode : graph[Node]){
                if(color[adjNode] == -1){
                    color[adjNode] = 1 - color[Node];
                    q.add(adjNode);
                }
                else if(color[adjNode] == color[Node]){
                    return false;
                }
            }
        }
        return true;
    }
}