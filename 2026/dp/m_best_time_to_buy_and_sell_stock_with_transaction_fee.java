// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

// RECURSIVE
class Solution {

    public int maxProfit(int[] prices, int fee) {
        return maxProfit(prices, fee, 0, 0);
    }

    private int maxProfit(int[] prices, int fee, int currIndex, int buyOrSell) {
        // BASE CASE
        if (currIndex >= prices.length) {
            return 0;
        }

        if (buyOrSell == 0) {
            // can buy
            int buy = maxProfit(prices, fee, currIndex + 1, 1) + (prices[currIndex] * (-1));
            int dontBuy = maxProfit(prices, fee, currIndex + 1, 0);

            return Math.max(buy, dontBuy);
        } else {
            //can sell
            int sell = maxProfit(prices, fee, currIndex + 1, 0) + prices[currIndex] + (fee * (-1));
            int dontSell = maxProfit(prices, fee, currIndex + 1, 1);

            return Math.max(sell, dontSell);
        }
    }
}

// TOP-DOWN
class Solution {

    public int maxProfit(int[] prices, int fee) {
        int[][] cache = new int[prices.length][2];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maxProfit(prices, fee, 0, 0, cache);
    }

    private int maxProfit(int[] prices, int fee, int currIndex, int buyOrSell, int[][] cache) {
        // BASE CASE
        if (currIndex >= prices.length) {
            return 0;
        }

        if (cache[currIndex][buyOrSell] != -1) {
            return cache[currIndex][buyOrSell];
        }

        if (buyOrSell == 0) {
            // can buy
            int buy = maxProfit(prices, fee, currIndex + 1, 1, cache) + (prices[currIndex] * (-1));
            int dontBuy = maxProfit(prices, fee, currIndex + 1, 0, cache);

            cache[currIndex][buyOrSell] = Math.max(buy, dontBuy);
        } else {
            //can sell
            int sell = maxProfit(prices, fee, currIndex + 1, 0, cache) + prices[currIndex] + (fee * (-1));
            int dontSell = maxProfit(prices, fee, currIndex + 1, 1, cache);

            cache[currIndex][buyOrSell] = Math.max(sell, dontSell);
        }

        return cache[currIndex][buyOrSell];
    }
}
