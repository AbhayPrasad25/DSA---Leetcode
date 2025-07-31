class Solution {
    public boolean solved = false;
    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }

    public void backtrack(int row, int col, char[][] board) {
        if (row == board.length) {
            solved = true;
            return;
        }
        if (col == board.length) {
            backtrack(row + 1, 0, board);
            return;
        }
        if(solved){
            return;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, col, board, (char)('0'+i))) {
                    board[row][col] = (char)('0'+ i);
                    backtrack(row, col + 1, board);
                    if(solved) return;
                    board[row][col] = '.';
                }
            }
        } else {
            backtrack(row, col + 1, board);
        }
    }

    public boolean isValid(int row, int col, char[][] board, char num) {
        //check the row
        int temp = 0;
        while (temp < board.length) {
            if (board[row][temp] == num) {
                return false;
            }
            temp++;
        }
        //check the column
        int tempr = 0;
        while (tempr < board.length) {
            if (board[tempr][col] == num) {
                return false;
            }
            tempr++;
        }
        //now check the box;
        int tempr1 = assignStart(row);
        int tempc1 = assignStart(col);
        for (int i = tempr1; i < tempr1 + 3; i++) {
            for (int j = tempc1; j < tempc1 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int assignStart(int index) {
        if (index < 3) {
            return 0;
        } else if (index < 6) {
            return 3;
        }
        return 6;
    }
}