class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int lMax = prices[0];
        int lMin = prices[0];
        int n = prices.length;
        while(i < n - 1){
            // when the left value is greater than the right we have to not pick that vakue
            while(i < n - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            lMin = prices[i];
            // Pick the value which is smaller than the next
            while(i < n - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            lMax = prices[i];
            profit += lMax - lMin;
        }
        return profit;
    }
}