// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/

// RECURSIVE
class Solution {

    public long maximumProfit(int[] prices, int k) {
        return maximumProfit(prices, 0, 0, k);
    }

    public long maximumProfit(int[] prices, int currIndex, int buyOrSell, int transactionLimit) {
        // 0 - BUY or SELL
        // 1 - BOUGHT -> now onwards can only SELL/nSELL
        // 2 - SSELL -> now onwards can only BUY/nBUY

        // BASE CASE: transactionLimit OVER -> check if we have shortSell stock with us
        if (transactionLimit == 0) {
            return buyOrSell == 2 ? Long.MIN_VALUE : 0l;
        }

        // BASE CASE: Index out of bound -> check if we have shortSell stock with us
        if (currIndex >= prices.length) {
            return buyOrSell == 2 ? Long.MIN_VALUE : 0l;
        }

        if (buyOrSell == 0) {
            long buy = maximumProfit(prices, currIndex + 1, 1, transactionLimit) + (prices[currIndex] * (-1));
            long dontBuy = maximumProfit(prices, currIndex + 1, 0, transactionLimit);
            long shortSell = maximumProfit(prices, currIndex + 1, 2, transactionLimit) + prices[currIndex];

            return Math.max(buy, Math.max(dontBuy, shortSell));
        } else if (buyOrSell == 1) {
            long sell = maximumProfit(prices, currIndex + 1, 0, transactionLimit - 1) + prices[currIndex];
            long dontSell = maximumProfit(prices, currIndex + 1, 1, transactionLimit);

            return Math.max(sell, dontSell);
        } else {
            // buyOrSell = 2 is short sell sinario
            long buy = maximumProfit(prices, currIndex + 1, 0, transactionLimit - 1) + (prices[currIndex] * (-1));
            long dontBuy = maximumProfit(prices, currIndex + 1, 2, transactionLimit);

            return Math.max(buy, dontBuy);
        }
    }
}

// TOP-DOWN
class Solution {

    public long maximumProfit(int[] prices, int k) {
        long[][][] cache = new long[prices.length][3][k + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        return maximumProfit(prices, 0, 0, k, cache);
    }

    public long maximumProfit(int[] prices, int currIndex, int buyOrSell, int transactionLimit, long[][][] cache) {
        // 0 - BUY or SELL
        // 1 - BOUGHT -> now onwards can only SELL/nSELL
        // 2 - SSELL -> now onwards can only BUY/nBUY

        // BASE CASE: transactionLimit OVER -> check if we have shortSell stock with us
        if (transactionLimit == 0) {
            return buyOrSell == 2 ? Long.MIN_VALUE : 0l;
        }

        // BASE CASE: Index out of bound -> check if we have shortSell stock with us
        if (currIndex >= prices.length) {
            return buyOrSell == 2 ? Long.MIN_VALUE : 0l;
        }

        if (cache[currIndex][buyOrSell][transactionLimit] != -1) {
            return cache[currIndex][buyOrSell][transactionLimit];
        }

        if (buyOrSell == 0) {
            long buy = maximumProfit(prices, currIndex + 1, 1, transactionLimit, cache) + (prices[currIndex] * (-1));
            long dontBuy = maximumProfit(prices, currIndex + 1, 0, transactionLimit, cache);
            long shortSell = maximumProfit(prices, currIndex + 1, 2, transactionLimit, cache) + prices[currIndex];

            cache[currIndex][buyOrSell][transactionLimit] = Math.max(buy, Math.max(dontBuy, shortSell));
        } else if (buyOrSell == 1) {
            long sell = maximumProfit(prices, currIndex + 1, 0, transactionLimit - 1, cache) + prices[currIndex];
            long dontSell = maximumProfit(prices, currIndex + 1, 1, transactionLimit, cache);

            cache[currIndex][buyOrSell][transactionLimit] = Math.max(sell, dontSell);
        } else {
            // buyOrSell = 2 is short sell sinario
            long buy = maximumProfit(prices, currIndex + 1, 0, transactionLimit - 1, cache) + (prices[currIndex] * (-1));
            long dontBuy = maximumProfit(prices, currIndex + 1, 2, transactionLimit, cache);

            cache[currIndex][buyOrSell][transactionLimit] = Math.max(buy, dontBuy);
        }

        return cache[currIndex][buyOrSell][transactionLimit];
    }
}
