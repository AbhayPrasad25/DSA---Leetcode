class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] delRow = { 0, 1, 0, -1 };
        int[] delCol = { 1, 0, -1, 0 };
        boolean[][] vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // traverse only the boundary land cell
                if(i == 0 || i == grid.length - 1 ||
                j == 0 || j == grid[0].length - 1){
                    if(!vis[i][j] && grid[i][j] == 1){
                        bfs(i , j, grid, vis, delRow, delCol);
                    }
                }
            }
        }
        //count of unvisted lands
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col });
        while (!q.isEmpty()) {
            int[] grd = q.poll();
            int curRow = grd[0];
            int curCol = grd[1];
            for (int i = 0; i < delRow.length; i++) {
                int nRow = delRow[i] + curRow;
                int nCol = delCol[i] + curCol;
                if (isValid(nRow, nCol, grid, vis)) {
                    vis[nRow][nCol] = true;
                    q.add(new int[] { nRow, nCol });
                }
            }
        }
    }
    private boolean isValid(int row, int col, int[][] grid, boolean[][] vis) {
        if ((row >= 0 && row < grid.length)
                && (col >= 0 && col < grid[0].length)
                && (grid[row][col] == 1)
                && (!vis[row][col])) {
            return true;
        }
        return false;
    }
}