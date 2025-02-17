/*
Idea: Keep track of max profit during linear iteration.

1. By default, we know to initially set profit = 0. If profit is not updated at all during our algorithm, we just return 0.

2. Automatically set the first price as the buyPrice. Then, iterate over the prices array starting from the second element to compute possible profits.

3. If the following price is greater than our buyPrice, then we have a profit of price[i] - buyPrice. If this profit is greater than the current profit, then update profit. Else, do nothing.

4. Else if the following price is less, then we have a better buyPrice. Set buyPrice = prices[i + 1]

By the end of the array, the maximum profit will have been determined.

Time complexity: O(N)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }
            else {
                profit = Math.max(profit, prices[i] - curMin);
            }
        }

        return profit;
    }
}
