class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        //defineng a direction array
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        //boolean array to keep track of the visited nodes
        boolean[][] vis = new boolean[row][col];
        //to count the number of islands
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    island++;
                    bfs(i, j, grid, vis, direction);
                }
            }
        }
        return island;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] vis, int[][] direction) {
        //marked the node as visted
        vis[row][col] = true;
        for (int[] direc : direction) {
            int nRow = row + direc[0];
            int nCol = col + direc[1];
            if (isValid(nRow, nCol, grid, vis)) {
                vis[nRow][nCol] = true;
                dfs(nRow, nCol, grid, vis, direction);
            }
        }
    }

    private boolean isValid(int row, int col, char[][] grid, boolean[][] vis) {
        if ((row >= 0 && row < grid.length)
                && (col >= 0 && col < grid[0].length)
                && (grid[row][col] == '1')
                && (vis[row][col] == false)) {
            return true;
        }
        return false;
    }

    public void bfs(int i, int j, char[][] grid, boolean[][] vis, int[][] direction) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new int[] { i, j });

        while (!q.isEmpty()) {
            // Get the cell from the queue
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            // Traverse in all directions
            for (int[] direc : direction) {
                int nRow = r + direc[0]; // Fixed: use current row 'r'
                int nCol = c + direc[1]; // Fixed: use current col 'c'

                if (isValid(nRow, nCol, grid, vis)) {
                    vis[nRow][nCol] = true;
                    q.add(new int[] { nRow, nCol });
                }
            }
        }
    }

}