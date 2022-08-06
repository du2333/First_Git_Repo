package leetcode.dailychallenge;

public class n458_poor_pigs {
    /*
    *   一只小猪代表一个维度(设为n), 每只小猪可以测试的次数+1为这只小猪在本维度上可以确定的点的数量(设为s), 则组成的n维空间中的总的点的数量为 s^n .

    *    小猪喝水策略: 把所有的水桶排成一个n维的n方体, 每只小猪喝垂直于本维度(轴)的一个"超平面".

    *    如2只小猪, 5个点. 25桶水排成一个矩形, 一只喝行, 一只喝列. 2只小猪确定一个点(***).

    *    如3只小猪, 5个点. 125桶水排成一个立方体, 一只喝垂直于x轴的面, 一只喝垂直于y轴的面, 一只喝垂直于z轴的面. 3只小猪确定一个点(***).

    *    如n只小猪, 5个点. 5^n桶水排成一个n方体, 每只喝垂直于本维度的一个"超平面"上的所有的水. n只小猪确定n维空间中的一个点(***).
    * */
    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            //可以尝试的次数
            int times = minutesToTest / minutesToDie;
            int base = times + 1;
            // base ^ ans >= buckets
            // ans >= log(buckets) / log(base)
            double temp = Math.log(buckets) / Math.log(base);
            int ans = (int)Math.ceil(temp);
            return ans;
        }
    }
    /*
    * 假设：总时间 minutesToTest = 60，死亡时间 minutesToDie = 15，pow(x, y) 表示 x 的 y 次方，ceil(x)表示 x 向上取整
    当前有 1 只小猪，最多可以喝 times = minutesToTest / minutesToDie = 4 次水
    最多可以喝 4 次水，能够携带 base = times + 1 = 5 个的信息量，也就是（便于理解从 0 开始）：
        (1) 喝 0 号死去，0 号桶水有毒
        (2) 喝 1 号死去，1 号桶水有毒
        (3) 喝 2 号死去，2 号桶水有毒
        (4) 喝 3 号死去，3 号桶水有毒
        (5) 喝了上述所有水依然活蹦乱跳，44 号桶水有毒
    结论是 1 只小猪最多能够验证 5 桶水中哪只水桶含有***，当 buckets ≤ 5 时，answer = 1
    那么 2 只小猪可以验证的范围最多到多少呢？我们把每只小猪携带的信息量看成是 base进制数，2 只小猪的信息量就是 pow(base, 2) = pow(5, 2) = 25，所以当 5 ≤ buckets ≤ 25时，answer = 2
    那么可以得到公式关系：pow(base, ans) ≥ buckets，取对数后即为：ans ≥ log(buckets) / log(base)，因为 ans 为整数，所以 ans = ceil(log(buckets) / log(base))

    * */
}
