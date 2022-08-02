package leetcode.dailychallenge;

public class n62_unique_paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //当起点和终点在同一列或同一行时，只有一条路
        for (int i = 0; i < m; ++i)
            dp[i][0] = 1;
        for (int i = 0; i < n; ++i)
            dp[0][i] = 1;

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                //核心dp公式
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
