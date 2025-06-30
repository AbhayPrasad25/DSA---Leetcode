class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] delRow ={0,1,0,-1};
        int[] delCol = {1,0,-1,0};
        int total = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(grid[i][j] != 0){
                    total++;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        boolean[][] vis = new boolean[row][col];
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i , j});
                }
            }
        }
        //bfs traversal
        int count = 0;
        while(!q.isEmpty()){
            int k = q.size();
            count += k;
            while(k-- > 0){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for(int i = 0; i < 4; i++){
                    int nRow = delRow[i] + r;
                    int nCol = delCol[i] + c;
                    if(isValid(nRow, nCol, grid)){
                        grid[nRow][nCol] = 2;
                        q.add(new int[]{nRow, nCol});
                    }
                }
            }
            if(!q.isEmpty()){
                time++;
            }
        }
        return total != count ? -1 : time;
    }

    public boolean isValid(int row, int col , int[][] grid){
        if((row >= 0 && row < grid.length)
        &&(col >= 0 && col < grid[0].length)
        &&(grid[row][col] == 1)){
            return true;
        }
        return false;
    }
}