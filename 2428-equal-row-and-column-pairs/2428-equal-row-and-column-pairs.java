class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String , Integer> map = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++){
                str.append(grid[i][j]).append(",");
            }
            map.put(str.toString() , map.getOrDefault(str.toString() , 0) + 1);
        }
        // Now itrating column wise and checking the number of equal pairs and column
        int count = 0;
        for(int i = 0; i < n; i++){
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < m; j++){
                str.append(grid[j][i]).append(",");
            }
            count += map.getOrDefault(str.toString() , 0);
        }
        return count;
    }
}