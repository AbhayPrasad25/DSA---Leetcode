class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(dfs(i, 0, graph, color) == false){
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
    private boolean dfs(int node, int Color,int[][] graph, int[] color){
        color[node] = Color;
        for(int adjNode : graph[node]){
            if(color[adjNode] == -1){
                if(dfs(adjNode, 1 - Color, graph, color) == false){
                    return false;
                }
            }
            else if(color[adjNode] == Color){
                return false;
            }
        }
        return true;
    }
}