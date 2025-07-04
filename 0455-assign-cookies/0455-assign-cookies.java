class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gL = 0;
        int sL = 0;
        int children = 0;
        while(gL < g.length && sL < s.length){
            if(g[gL] <= s[sL]){
                children++;
                gL++;
                sL++;
            }
            else{
                sL++;
            }
        }
        return children;
    }
}