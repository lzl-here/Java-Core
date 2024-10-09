package lzl.com.dp.oneSequence;

public class SellStock {
    public static void main(String[] args) {

    }

    // region 买卖股票原始版 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/

    public int maxProfit(int[] prices) {

        int[] holdDp = new int[prices.length];
        int[] emptyDp = new int[prices.length];
        holdDp[0] = -prices[0];
        emptyDp[0] = 0;
        // 两种状态：手上有股票，手上没股票
        // 手上没股票时赚的最多的钱
        // 手上有股票时花的最少的钱
        // 赚的最多的钱 = Max（之前赚的最多的钱， 今天卖出去赚的最大的钱）
        for (int i = 1; i < prices.length; i++) {
            emptyDp[i] = Math.max(emptyDp[i - 1], holdDp[i - 1] + prices[i]);
            holdDp[i] = Math.max(holdDp[i - 1], -prices[i]);
        }
        return emptyDp[prices.length - 1];
    }

    // endregion
}
