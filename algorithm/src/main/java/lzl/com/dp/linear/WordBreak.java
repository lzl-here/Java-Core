package lzl.com.dp.linear;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
    }

    //region word break https://leetcode.cn/problems/word-break/
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[10000000];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                String word = s.substring(j, i + 1);
                if (wordSet.contains(word)) {
                    dp[i + 1] = dp[i + 1] || dp[i - word.length() + 1];
                }
            }
        }
        return dp[s.length()];
    }
    // endregion

    // region word break 2  https://leetcode.cn/problems/word-break-ii/
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return null;
    }
    // endregion
}
