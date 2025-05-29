class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < mountain.length; i++){
            if(i != 0 && i != mountain.length - 1){
                if(mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}