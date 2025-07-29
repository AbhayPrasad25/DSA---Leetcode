class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for(int i = 0; i < n; i++){
            board.add(s);
        }
        placeQueens(board, ans, 0);
        return ans;
    }
    public static void placeQueens(List<String> board, List<List<String>> ans, int row){
        if(row == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int i = 0; i < board.size(); i++){
            if(isValid(row, i , board)){
                char[] boardRow = board.get(row).toCharArray();
                boardRow[i] = 'Q';
                board.set(row, String.valueOf(boardRow));
                //move to the next row to place the quuens
                placeQueens(board, ans, row + 1);
                //again revert it back
                boardRow[i] = '.';
                board.set(row, String.valueOf(boardRow));
            }
        }
    }
    public static boolean isValid(int row, int col, List<String> board){
        // check vertically if there is any queen 
        int tempr1 = row;
        while(tempr1 >= 0){
            if(board.get(tempr1).charAt(col) == 'Q'){
                return false;
            }
            tempr1--;
        }
        //now check the left diagonal
        int tempr2 = row, tempc2 = col;
        while(tempr2 >= 0 && tempc2 >= 0){
            if(board.get(tempr2).charAt(tempc2) == 'Q'){
                return false;
            }
            tempr2--;
            tempc2--;
        }

        //now check the right diagonal
        int tempr3 = row, tempc3 = col;
        while(tempr3 >= 0 && tempc3 < board.size()){
            if(board.get(tempr3).charAt(tempc3) == 'Q'){
                return false;
            }
            tempr3--;
            tempc3++;
        }
        return true;
    }
}