class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        //DFS Method
        // int V = graph.length;
        // boolean[] checkSafe = new boolean[V];
        // boolean[] visited = new boolean[V];
        // boolean[] pathVisit = new boolean[V];

        // for(int i = 0; i < V; i++){
        //     if(!visited[i]){
        //         dfs(i, graph, visited, checkSafe, pathVisit);
        //     }
        // }
        // List<Integer> safeState = new ArrayList<>();
        // //now add the safe nodes to the lsit
        // for(int i = 0; i < V; i++){
        //     if(checkSafe[i] == true){
        //         safeState.add(i);
        //     }
        // }
        // return safeState;

        //BFS Method using topo sort
        int V = adj.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adjRev.add(new ArrayList<>());
        }
        int[] inDegree = new int[V];
        for(int i = 0; i < adj.length; i++){
            for(int node : adj[i]){
                adjRev.get(node).add(i);
                inDegree[i]++;
            }
        }
        //now the edges have been reverse now we will apply topological sorting
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> safe = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            safe.add(node);
            for(int adjNode : adjRev.get(node)){
                inDegree[adjNode]--;
                //when the inDegree becomes zero add it to the Queue
                if(inDegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        Collections.sort(safe);
        return safe;
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