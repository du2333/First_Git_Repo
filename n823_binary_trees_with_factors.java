package leetcode.dailychallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n823_binary_trees_with_factors {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int)1e9+7;
        int n = arr.length;

        //dp[i]表示以arr[i]作为根节点可以组成树的数量
        long[] dp = new long[n];
        //记录<value，index>对
        Map<Integer, Integer> hash = new HashMap();

        //对原数组进行升序，因为树的根节点永远是最大值
        Arrays.sort(arr);
        //每个数字本身可以组成一颗只有一个节点的树，也算一种
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; ++i)
            hash.put(arr[i], i);

        for(int i = 0; i < n; ++i){
            //对于每个i，j就是i前面的数字，都比他小
            for(int j = 0; j < i; ++j){
                //如果可以整除
                if(arr[i] % arr[j] == 0){
                    //就在hashmap里寻找除数
                    int num = arr[i] / arr[j];
                    //找到了就把他添加到dp数组里
                    if(hash.containsKey(num))
                        dp[i] = (dp[i] + dp[j] * dp[hash.get(num)]) % mod;
                }
            }
        }

        //答案就是所有dp的累加
        long ans = 0;
        for(long x : dp) ans += x;

        return (int) (ans % mod);
    }
}
