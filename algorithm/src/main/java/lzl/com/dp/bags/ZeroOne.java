package lzl.com.dp.bags;

import java.util.Arrays;

/**
 * 01背包
 *
 * 写之前一定要先看怎么初始化！！！
 */
public class ZeroOne {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2,2,1,1}));
    }

    // region 01背包模板
    static int zeroOneBags(int[] values, int[] weights, int N, int M) {
        int[][] dp = new int[N + 1][M + 1];

        for (int j = 0; j <= M; ++j) {
            if (weights[0] <= j) {
                dp[0][j] = values[j];
            }
        }
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j <= M; ++j) {
                if (j >= weights[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][M];
    }

    /**
     * 滚动数组写法
     */
    static int zeroOneBags2(int[] values, int[] weights, int N, int M) {
        int[] dp = new int[M + 1];
        for (int i = 1; i < N; ++i) {
            // 01背包的滚动数组写法遍历j是从右往左，这时因为i依赖于i-1的状态
            for (int j = M; j >= weights[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[M];
    }
    // endregion

    // region 分割等和子集 https://leetcode.cn/problems/partition-equal-subset-sum/description/
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int bagSize = sum / 2;

        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[bagSize] == bagSize;
    }
    // endregion

    // region 一零和 https://leetcode.cn/problems/ones-and-zeroes/description/
    // 物品有多维度的重量
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            Pair pair = getZeroAndOnes(strs[i]);
            int zero = pair.zero;
            int one = pair.one;
            for(int j = m; j >= zero; --j){
                for(int k = n; k >= one; --k){
                    dp[j][k] = Math.max( dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static Pair getZeroAndOnes(String str){
        int zero = 0;
        int one = 0;
        for(char c : str.toCharArray()){
            if(c == '0'){
                zero ++;
            }
            if(c == '1'){
                one ++;
            }
        }
        return new Pair(zero, one);
    }

    private static class Pair{
        private int zero;
        private int one;
        public Pair(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }
    // endregion

    // region 目标和 https://leetcode.cn/problems/target-sum/
//    public int findTargetSumWays(int[] nums, int target) {
//     TODO：目标和
//    }
    // endregion

//    // region 最后一块石头的重量 https://leetcode.cn/problems/last-stone-weight-ii/description/
//    public int lastStoneWeightII(int[] stones) {
//     TODO：最后一块石头的重量
//    }
    // endregion
}