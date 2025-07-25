class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //to show dpenendency of each course on anotther we make a graph
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int course1 = prerequisites[i][1];
            int course2 = prerequisites[i][0];
            adjList.get(course1).add(course2);
        }
        List<Integer> topsort= toposorting(numCourses, adjList);
        if(topsort.size() != numCourses){
            return new int[]{};
        }
        int[] topo = new int[topsort.size()];
        for(int i = 0; i < topsort.size(); i++){
            topo[i] = topsort.get(i);
        }
        return topo;
    }
    public List<Integer> toposorting(int numCourses, List<List<Integer>> adjList){
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int adjNode : adjList.get(i)){
                inDegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        //reduce the indegree as you process every node
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int adjNode : adjList.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        return topo;
    }
}