class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> win = new HashMap<>();
        HashMap<Integer, Integer> loss = new HashMap<>();
        for(int[] match : matches){
            win.put(match[0], win.getOrDefault(match[0], 0) + 1);
            loss.put(match[1], loss.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(var entry : win.entrySet()){
            if(!loss.containsKey(entry.getKey())){
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        ans.add(res);
        List<Integer> res2 = new ArrayList<>();
        for(var entry: loss.entrySet()){
            if(entry.getValue() == 1){
                res2.add(entry.getKey());
            }
        }
        Collections.sort(res2);
        ans.add(res2);
        return ans;
    }
}