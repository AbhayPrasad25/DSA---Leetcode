class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjLst = new ArrayList<>();
        int v = isConnected.length;
        //lsit made now we need to fill it in the next step
        for(int i = 0; i < v; i++){
            adjLst.add(new ArrayList<>());
        }

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLst.get(i).add(j);
                    adjLst.get(j).add(i);
                }
            }
        }
        //now either i make a integer array or boolean array to keep track of the vistied nodes
        int[] vis = new int[v];
        //counter variable to keep the track of provinces
        int cnt = 0;
        for(int i = 0 ; i < v; i++){
            if(vis[i] == 0){
                cnt++;
                bfs(i , adjLst, vis);
            }
        }
        return cnt;
    }
    private void dfs(int v , List<List<Integer>> adjLst , int[] vis){
        vis[v] = 1;
        for(int node : adjLst.get(v)){
            if(vis[node] != 1){
                vis[node] = 1;
                dfs(node, adjLst, vis);
            }
        }
    }
    public void bfs(int v, List<List<Integer>> adjLst, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        vis[v] = 1;
        q.add(v);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : adjLst.get(node)){
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.add(adjNode);
                }
            }
        }
    }
}