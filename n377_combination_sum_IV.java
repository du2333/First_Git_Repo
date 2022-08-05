package leetcode.dailychallenge;

public class n377_combination_sum_IV {
    public int combinationSum4(int[] nums, int target) {
        //使用dp数组，dp[i]代表target为i时使用nums中的数能组成的组合数的个数
        int[] dp = new int[target + 1];
        //初始情况，能组合成0的组合就是什么都不选择，只有一种
        dp[0] = 1;
        //举个例子比如nums=[1,3,4],target=7;
        //dp[7]=dp[6]+dp[4]+dp[3]
        //其实就是说7的组合数可以由三部分组成，1和dp[6]，3和dp[4],4和dp[3];
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                //当num小于等于target的时候才可以和其他数相加成target
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
