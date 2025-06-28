class Solution {
    public int findCircleNum(int[][] adj) {
        int v = adj.length;
        int cnt = 0;
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                cnt++;
                dfs(i , adj , vis);
            }
        }
        return cnt;
    }
    public void dfs(int v, int[][] adj, boolean[] vis){
        vis[v] = true;
        for(int i = 0; i < adj.length; i++){
            if(adj[v][i] == 1 && !vis[i]){
                vis[i] = true;
                dfs(i , adj , vis);
            }
        }
    }
}