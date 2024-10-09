package lzl.com.dp.oneSequence;

import lzl.com.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobHouse {
    public static void main(String[] args) {

    }

    // region 打家劫舍 https://leetcode.cn/problems/house-robber/description/
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
    // endregion

    // region 打家劫舍2 https://leetcode.cn/problems/house-robber-ii/description/
    public int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        // 两种情况，抢第一家
        int[] dpRobFirst = new int[nums.length];
        // 不抢第一家
        int[] dpNotFirst = new int [nums.length];
        dpRobFirst[0] = nums[0];
        dpRobFirst[1] = dpRobFirst[0];
        dpNotFirst[0] = 0;
        dpNotFirst[1] = nums[1];
        for(int i = 2; i < nums.length; ++i){
            if(i == nums.length - 1){
                dpRobFirst[i] = dpRobFirst[i - 1];
                dpNotFirst[i] = Math.max(dpNotFirst[i - 1], dpNotFirst[i - 2] + nums[i]);
            }else{
                dpRobFirst[i] = Math.max(dpRobFirst[i - 1], dpRobFirst[i - 2] + nums[i]);
                dpNotFirst[i] = Math.max(dpNotFirst[i - 1], dpNotFirst[i - 2] + nums[i]);
            }

        }
        return Math.max(dpNotFirst[nums.length - 1], dpRobFirst[nums.length - 1]);
    }
    // endregion

    // region 打家劫舍3 https://leetcode.cn/problems/house-robber-iii/description/
    public int rob3(TreeNode root) {
        Map<TreeNode, Integer> dpMap = new HashMap<>();
        return doRob(root, dpMap);
    }

    private int doRob(TreeNode root, Map<TreeNode, Integer> dpMap){
        if(root == null){
            return 0;
        }
        if(dpMap.containsKey(root)){
            return dpMap.get(root);
        }

        int robRoot = root.val;
        if(root.left != null){
            robRoot += doRob(root.left.left, dpMap);
            robRoot += doRob(root.left.right, dpMap);
        }
        if(root.right != null){
            robRoot += doRob(root.right.left, dpMap);
            robRoot += doRob(root.right.right, dpMap);
        }
        int notRobRoot = doRob(root.left, dpMap) + doRob(root.right, dpMap);
        int res = Math.max(robRoot, notRobRoot);
        dpMap.put(root, res);
        return res;
    }
    // endregion
}
