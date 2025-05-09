class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < n; j++){
                l.add(grid[i][j]);
            }
            map.put(l , map.getOrDefault(l , 0) + 1);
        }
        // Now itrating column wise and checking the number of equal pairs and column
        int count = 0;
        for(int i = 0; i < n; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < m; j++){
                l.add(grid[j][i]);
            }
            count += map.getOrDefault(l , 0);
        }
        return count;
    }
}