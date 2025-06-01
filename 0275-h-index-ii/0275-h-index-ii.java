class Solution {
    public int hIndex(int[] citations) {
        int index = 0;
        int left = 0;
        int n = citations.length;
        int right = citations.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(citations[mid] >= n - mid){
                index = n - mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return index;
    }
}