class Solution {
    public int[][] merge(int[][] intervals) {
        //sorting the 2d array based on the starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] , b[0]));
        ArrayList<int[]> mergedInterval = new ArrayList<>();
        int low = intervals[0][0];
        int high = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(high < intervals[i][0]){
                mergedInterval.add(new int[]{low, high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
            else{
                high = Math.max(high, intervals[i][1]);
            }
        }
        mergedInterval.add(new int[]{low, high});
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}