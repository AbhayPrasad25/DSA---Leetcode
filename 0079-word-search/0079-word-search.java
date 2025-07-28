class Solution {
    public boolean exist(char[][] board, String word) {
        int[] decRow = {1,0,-1,0};
        int[] decCol = {0,1,0,-1};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 1, decRow, decCol, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isValid(int row, int col, char[][] board, boolean[][] visited){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length|| visited[row][col]){
            return false;
        }
        return true;
    }
    public boolean dfs(char[][] board, int row, int col, String word, int index, int[] decRow, int[]decCol, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        visited[row][col] = true;
        for(int i = 0; i < decRow.length; i++){
            int nRow = row + decRow[i];
            int nCol = col + decCol[i];
            if(isValid(nRow, nCol, board, visited)){
                if(index < word.length() && board[nRow][nCol] == word.charAt(index)){
                    if(dfs(board, nRow, nCol, word, index + 1, decRow, decCol, visited)){
                        return true;
                    }
                }
            }
        }
        visited[row][col] = false;
        return false;
    }
}