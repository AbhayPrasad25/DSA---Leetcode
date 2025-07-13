class Solution {
    static class pair{
        public int row;
        public int col;
        public int val;
        pair(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] range = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(new pair(i , j , mat[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            pair box = q.poll();
            int row = box.row;
            int col = box.col;
            int data = box.val;
            if(mat[row][col] == 1){
                mat[row][col] = data;
            }
            for(int i = 0; i < 4; i++){
                int nRow = range[i][0] + row;
                int nCol = range[i][1] + col;
                if(isValid(mat, visited, nRow, nCol) && mat[nRow][nCol] == 1){
                    visited[nRow][nCol] = true;
                    q.offer(new pair(nRow, nCol, data + 1));
                }
            }
        }
        return mat;
    }
    public boolean isValid(int[][] mat, boolean[][] visited, int row, int col){
        if(row < 0|| row >= mat.length || col < 0 || col >= mat[0].length || visited[row][col] == true ){
            return false;
        }
        return true;
    }
}