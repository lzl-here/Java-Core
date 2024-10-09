package lzl.com.dp.oneSequence;

public class SubArray {
    public static void main(String[] args) {

    }

    // region  最大子数和 https://leetcode.cn/problems/maximum-subarray/description/
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[1000];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // endregion

    // region 乘积最大子数组 https://leetcode.cn/problems/maximum-product-subarray/description/
    public static int maxProduct(int[] nums) {
        // max，min分别维护了第i位置的前面最大/小的序列乘积
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = nums[0];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果当前num是正的，我们希望前面最大的值
            // 如果当前num是负的，我们希望前面最小的值
            if(nums[i] > 0){
                res = Math.max(res, nums[i] * max[i - 1]);
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            }else{
                res = Math.max(res, nums[i] * min[i - 1]);
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
    // endregion
}
