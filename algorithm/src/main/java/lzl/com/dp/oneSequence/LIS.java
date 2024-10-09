package lzl.com.dp.oneSequence;

import java.util.Arrays;

/**
 * 子序列问题
 */
public class LIS {

    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{1,2,6,8}, 2));
    }

    // region （LIS问题）最长递增子序列。https://leetcode.cn/problems/longest-increasing-subsequence/

    /**
     * n^2解法 动态规划
     */
    public static int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]结尾的最大递增子序列长度
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    /**
     * nlog(n) 解法: 单调递增序列，使用二分查找
     */
    public static int lengthOfLIS2(int[] nums) {
        int len = 1;
        int[] orderArray = new int [nums.length];
        for(int i = 0; i < nums.length; ++i){
            int num = nums[i];
            int pos = Arrays.binarySearch(orderArray, 0, len, num);
            // 不在orderArray中，pos转化成应该插入的位置
            if(pos < 0){
                pos = -(pos + 1);
            }
            orderArray[pos] = num;
            // 如果新来的num是加在orderArray末尾，没有删除别的元素 (比orderArray所有元素都大)
            if(pos == len){
                len++;
            }
        }
        return len;
    }

    // endregion


//    // region （LIS问题）得到子序列的最少操作次数 https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/description/
//    public int minOperations(int[] target, int[] arr) {
//        TODO：LIS问题
//    }
    // endregion
}
