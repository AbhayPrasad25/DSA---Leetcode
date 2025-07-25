class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisit = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i , visited, pathVisit, adjList)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, boolean[] visited, boolean[] path, List<List<Integer>> adjList){
        visited[node] = true;
        path[node] = true;
        for(int adjNode : adjList.get(node)){
            if(!visited[adjNode]){
                if(dfs(adjNode, visited, path, adjList)){
                    return true;
                }
            }
            else{
                if(path[adjNode]){
                    return true;
                }
            }
        }
        path[node] =  false;
        return false;
    }
}