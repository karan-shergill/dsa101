// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

// RECURSIVE
class Solution {

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 0);
    }

    private int maxProfit(int[] prices, int currIndex, int buyOrSell) {
        // BASE CASE
        if (currIndex >= prices.length) {
            return 0;
        }

        if (buyOrSell == 0) {
            // can buy
            int buy = maxProfit(prices, currIndex + 1, 1) + (prices[currIndex] * (-1));
            int dontBuy = maxProfit(prices, currIndex + 1, 0);

            return Math.max(buy, dontBuy);
        } else {
            //can sell
            int sell = maxProfit(prices, currIndex + 2, 0) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, 1);

            return Math.max(sell, dontSell);
        }
    }
}

// TOP-DOWN
class Solution {

    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length][2];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maxProfit(prices, 0, 0, cache);
    }

    private int maxProfit(int[] prices, int currIndex, int buyOrSell, int[][] cache) {
        // BASE CASE
        if (currIndex >= prices.length) {
            return 0;
        }

        if (cache[currIndex][buyOrSell] != -1) {
            return cache[currIndex][buyOrSell];
        }

        if (buyOrSell == 0) {
            // can buy
            int buy = maxProfit(prices, currIndex + 1, 1, cache) + (prices[currIndex] * (-1));
            int dontBuy = maxProfit(prices, currIndex + 1, 0, cache);

            cache[currIndex][buyOrSell] = Math.max(buy, dontBuy);
        } else {
            //can sell
            int sell = maxProfit(prices, currIndex + 2, 0, cache) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, 1, cache);

            cache[currIndex][buyOrSell] = Math.max(sell, dontSell);
        }

        return cache[currIndex][buyOrSell];
    }
}
