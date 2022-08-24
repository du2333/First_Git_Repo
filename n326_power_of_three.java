package leetcode.dailychallenge;

public class n326_power_of_three {
    //判断是否为最大 33 的幂的约数
    //在题目给定的32位有符号整数的范围内，最大的3的幂为 3^19 = 11622614673
    //我们只需要判断n是否是3^19的约数即可。
    class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }
}
