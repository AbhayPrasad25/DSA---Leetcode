class Solution {
    public int maxProfit(int[] prices) {
        int aheadBuy = 0, aheadNotBuy = 0;
        int n = prices.length;
        for(int i = n - 1; i >= 0; i--){
            int currBuy = Math.max(aheadBuy, prices[i] + aheadNotBuy);
            int currNotBuy = Math.max(aheadNotBuy, -prices[i] + aheadBuy);
            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }
        return aheadNotBuy;
    }
}