class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] checkSafe = new boolean[V];
        boolean[] visited = new boolean[V];
        boolean[] pathVisit = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, graph, visited, checkSafe, pathVisit);
            }
        }
        List<Integer> safeState = new ArrayList<>();
        //now add the safe nodes to the lsit
        for(int i = 0; i < V; i++){
            if(checkSafe[i] == true){
                safeState.add(i);
            }
        }
        return safeState;
    }
    //dfs traversal to check for safe states
    public boolean dfs(int V, int[][] graph, boolean[] visited, boolean[] safe, boolean[] pathVisit){
        visited[V] = true;
        safe[V] = false;
        pathVisit[V] = true;
        for(int adjNode : graph[V]){
            if(!visited[adjNode]){
                if(dfs(adjNode, graph, visited, safe, pathVisit)){
                    return true;
                }
            }
            else if(pathVisit[adjNode]){
                return true;
            }
        }
        //now we Know that there was no cycle we will mark the node as safe
        safe[V] = true;
        pathVisit[V] = false;
        return false;
    }
}