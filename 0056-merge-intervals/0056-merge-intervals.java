class Solution {
    public int[][] merge(int[][] intervals) {
        //sorting the 2d array based on the starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] , b[0]));
        LinkedList<int[]> mergedInterval = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergedInterval.isEmpty() || mergedInterval.getLast()[1] < interval[0]){
                mergedInterval.add(interval);
            }
            else{
                mergedInterval.getLast()[1] = Math.max(mergedInterval.getLast()[1] , interval[1]);
            }
        }
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }
}