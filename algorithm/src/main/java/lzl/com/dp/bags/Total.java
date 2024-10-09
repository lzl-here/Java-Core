package lzl.com.dp.bags;

import java.util.Arrays;

/**
 * 完全背包
 *
 * 写之前一定要先判断初始化！！！
 */
public class Total {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{77,82,84,80,398,286,40,136,162}, 9794));
    }

    /**
     * 滚动数组写法，懒得用最原始写法了，滚动写法最方便
     */
    public static int TotalBags(int[] values, int[] weights, int N, int M){
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            // 这里j必须从左往右遍历，因为完全背包依赖于i依赖于i这一行的状态，而不是上一行i-1的状态
            for (int j = weights[i]; j <= M; ++j) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[M];
    }

    // region 零钱兑换  https://leetcode.cn/problems/coin-change/description/
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if(dp[j - coins[i]] == Integer.MAX_VALUE){
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // endregion
}
