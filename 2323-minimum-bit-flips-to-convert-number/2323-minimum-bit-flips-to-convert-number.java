class Solution {
    public int minBitFlips(int start, int goal) {
        int newNum = start ^ goal;
        // we will get a new number which has all the bits flipped 
        int count = 0;
        for(int i = 0; i < 31; i++){
            count += newNum & 1;
            newNum = newNum >> 1;
        }
        return count;
    }
}