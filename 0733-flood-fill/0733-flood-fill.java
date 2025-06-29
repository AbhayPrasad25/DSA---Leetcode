class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int r = image.length;
        int c = image[0].length;
        boolean[][] vis = new boolean[r][c];
        int[][] direction = {{0,1}, {1, 0}, {0, -1},{-1,0}};
        dfs(image, sr, sc, newColor, vis, direction, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int newColor, boolean[][] vis, int[][] direction, int color){
        vis[r][c] = true;
        image[r][c] = newColor;
        for(int [] direc : direction){
            int nRow = r + direc[0];
            int nCol = c + direc[1];
            if(isValid(nRow, nCol, vis, image, color)){
                int colur = image[nRow][nCol];
                vis[nRow][nCol] = true;
                dfs(image, nRow, nCol, newColor, vis, direction, colur);
            }
        }
    }
    private boolean isValid(int r, int c, boolean[][] vis, int[][] image, int Color){
        if((r >= 0 && r < image.length)
        &&(c >= 0 && c < image[0].length)
        &&(!vis[r][c])&&
        (image[r][c] == Color)){
            return true;
        }
        return false;
    }
}
