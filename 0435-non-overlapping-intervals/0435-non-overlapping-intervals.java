class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sorted
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int overlapping = 0;
        int high = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(high > intervals[i][0]){
                overlapping++;
            }
            else{
                high = intervals[i][1];
            }
        }
        return overlapping;
    }
}