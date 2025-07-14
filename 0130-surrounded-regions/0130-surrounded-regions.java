class Solution {
    public void solve(char[][] mat) {
        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,1,0,-1};
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        //do dfsTraversal on the edges and mark all the o which
        // are connected to it as false
        for(int i = 0; i < mat.length; i++){
            if(!visited[i][0] && mat[i][0] == 'O'){
                dfs(i, 0, delCol, delRow, visited, mat);
            }
            if(!visited[i][mat[0].length - 1] && mat[i][mat[0].length - 1] == 'O'){
               dfs(i, mat[0].length - 1, delCol, delRow, visited, mat); 
            }
        }
        for(int i = 0; i < mat[0].length; i++){
            if(!visited[0][i] && mat[0][i] == 'O'){
                dfs(0,i, delCol, delRow, visited, mat);
            }
            if(!visited[mat.length - 1][i] && mat[mat.length - 1][i] == 'O'){
               dfs(mat.length - 1,i, delCol, delRow, visited, mat); 
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(!visited[i][j] && mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(int row, int col, int[] delCol, int[] delRow, boolean[][] visited, char[][] mat){
        visited[row][col] = true;
        for(int i = 0 ; i < delRow.length; i++){
            int nRow =  row + delRow[i];
            int nCol = col + delCol[i];
            if(isValid(nRow, nCol, mat, visited) && mat[nRow][nCol] == 'O'){
                dfs(nRow, nCol, delCol, delRow, visited, mat);
            }
        }
    }
    public boolean isValid(int row, int col, char[][] mat, boolean[][] visited){
        if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || visited[row][col] == true){
            return false;
        }
        return true;
    }
}