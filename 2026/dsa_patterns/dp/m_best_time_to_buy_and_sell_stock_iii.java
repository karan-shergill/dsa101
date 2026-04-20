// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

// RECURSIVE
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 0, 2);
    }

    public int maxProfit(int[] prices, int currIndex, int buyOrSell, int transactionCount) {
        if (transactionCount == 0) {
            return 0;
        }

        if (currIndex >= prices.length) {
            return 0;
        }

        if (buyOrSell == 0) {
            // Need to BUY
            int buy = maxProfit(prices, currIndex + 1, 1, transactionCount) + (prices[currIndex] * -1);
            int dontBuy = maxProfit(prices, currIndex + 1, 0, transactionCount);

            return Math.max(buy, dontBuy);
        } else {
            // Need to SELL
            int sell = maxProfit(prices, currIndex + 1, 0, transactionCount - 1) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, 1, transactionCount);

            return Math.max(sell, dontSell);
        }
    }
}

// TOP-DOWN
class Solution {

    public int maxProfit(int[] prices) {
        int[][][] cache = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        return maxProfit(prices, 0, 0, 2, cache);
    }

    public int maxProfit(int[] prices, int currIndex, int buyOrSell, int transactionCount, int[][][] cache) {
        if (transactionCount == 0) {
            return 0;
        }

        if (currIndex >= prices.length) {
            return 0;
        }

        if (cache[currIndex][buyOrSell][transactionCount] != -1) {
            return cache[currIndex][buyOrSell][transactionCount];
        }

        if (buyOrSell == 0) {
            // Need to BUY
            int buy = maxProfit(prices, currIndex + 1, 1, transactionCount, cache) + (prices[currIndex] * -1);
            int dontBuy = maxProfit(prices, currIndex + 1, 0, transactionCount, cache);

            cache[currIndex][buyOrSell][transactionCount] = Math.max(buy, dontBuy);
        } else {
            // Need to SELL
            int sell = maxProfit(prices, currIndex + 1, 0, transactionCount - 1, cache) + prices[currIndex];
            int dontSell = maxProfit(prices, currIndex + 1, 1, transactionCount, cache);

            cache[currIndex][buyOrSell][transactionCount] = Math.max(sell, dontSell);
        }

        return cache[currIndex][buyOrSell][transactionCount];
    }
}
