/** 
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * O(n) time, O(1) space
 */

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length < 2) 
            return 0;

        int minProfit = prices[0];
        /* if negative, we have to return zero so initialized max zero. Else, set max to 'prices[1] - prices[0]' */
        int maxProfit = 0; 
        for (int i = 1; i < prices.length; ++ i)
        {
            /* to avoid buy and sell at the same time, we have to update maxProfit first*/
            maxProfit = Math.max(prices[i] - minProfit, maxProfit);
            minProfit = Math.min(prices[i], minProfit);
        }
        return maxProfit;      
    }
}           