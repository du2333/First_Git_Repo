package leetcode.dailychallenge;

public class n300_longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //dp[i]表示以在nums数组里以nums[i]结尾的最长子序列长度
        int[] dp = new int[n];
        int ans = 1;

        for(int i = 0; i < n; ++i){
            //每一个数字都可以组成最短长度为1的序列
            dp[i] = 1;
            //在[0,i)区间内寻找可以组成子序列的值
            for(int j = 0; j < i; ++j){
                //当nums[i]>nums[j]表示nums[i]可以作为dp[j]的结尾，最后组成的长度也就是dp[j]+1
                if(nums[i] > nums[j])
                    //更新dp[i]的长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            //记录最大值
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
