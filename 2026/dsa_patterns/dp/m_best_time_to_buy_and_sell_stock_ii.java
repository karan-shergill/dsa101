// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

// RECURSIVE
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 0);
    }

    private int maxProfit(int[] prices, int currIndex, int buyOrSell) {
        if (currIndex >= prices.length) {
            return 0;
        }

        if (buyOrSell == 0) {
            // need to BUY
            int buy = maxProfit(prices, currIndex + 1, 1) + (prices[currIndex] * -1);
            int dontBuy = maxProfit(prices, currIndex + 1, 0);

            return Math.max(buy, dontBuy);
        } else {
            // need to SELL
            int sell = maxProfit(prices, currIndex + 1, 0) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, buyOrSell);

            return Math.max(sell, dontSell);
        }
    }
}

// TOP-DOWN
class Solution {

    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return maxProfit(prices, 0, 0, cache);
    }

    private int maxProfit(int[] prices, int currIndex, int buyOrSell, int[][] cache) {
        if (currIndex >= prices.length) {
            return 0;
        }

        if (cache[currIndex][buyOrSell] != -1) {
            return cache[currIndex][buyOrSell];
        }

        if (buyOrSell == 0) {
            // need to BUY
            int buy = maxProfit(prices, currIndex + 1, 1, cache) + (prices[currIndex] * -1);
            int dontBuy = maxProfit(prices, currIndex + 1, 0, cache);

            cache[currIndex][buyOrSell] = Math.max(buy, dontBuy);
        } else {
            // need to SELL
            int sell = maxProfit(prices, currIndex + 1, 0, cache) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, buyOrSell, cache);

            cache[currIndex][buyOrSell] = Math.max(sell, dontSell);
        }

        return cache[currIndex][buyOrSell];
    }
}
