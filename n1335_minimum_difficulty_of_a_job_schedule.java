package leetcode.dailychallenge;

import java.util.Arrays;
/*
* 首先我们考虑，如果数组的个数小于d，那么无论如何我们也不能将数组分成d份，此时应该返回-1，
* 这是本题唯一一个例外情况。除此之外，我们可以从数组的首元素开始分组，对于第一组子数组，开始
* 位置的下标应该是0，结束下标的位置虽然不能确定，但是我们可以知道它的取值范围，即[0, length-d]
* 之间。结束位置是0很好理解，即首元素自己是一个分组。结束位置的最大取值是数组长度减去d，
* 这是为了保证，剩下的元素还能再分d-1组。

* 递归函数helper()中需要2个参数，一个是当前区间的起始下标start，另一个是剩余尚未分组的个数d，
* 递归函数中，我们循环结束下标end的取值范围，即start至length-d之间。利用end坐标我们可以将
* 数组分隔成为[start, end]和[end+1, 数组末尾]两部分。其中start到end区间为当前区间，当前
* 区间的最大值为区间难度值max，而end+1到数组末尾部分的分组交给子问题去解决，递归到子问题时，
* 区间起始下标为end加一，剩余尚未分组个数d减一。对于当前区间的每一种长度，都能计算出相应的最
* 终结果
* */
public class n1335_minimum_difficulty_of_a_job_schedule {
    class Solution {
        int[][] memo;//记忆数组
        public int minDifficulty(int[] jobDifficulty, int d) {
            int n = jobDifficulty.length;
            //如果工作数量小于天数，直接返回-1
            if(n < d) return -1;
            //初始化记忆数组，全部为-1
            memo = new int[n][d + 1];
            for(int[] row : memo) Arrays.fill(row, -1);
            return helper(jobDifficulty, 0, d);
        }

        /**
         *
         * @param jobDifficulty
         * @param curIndex 当前工作下标
         * @param d 剩余天数
         * @return 当前工作的最优解
         */
        int helper(int[] jobDifficulty, int curIndex, int d){
            //如果记忆数组已经存在该数据，直接返回
            if(memo[curIndex][d] != -1) return memo[curIndex][d];

            //当前工作的最大难度
            int curMaxDifficulty = 0;
            //当前最优解
            int res = Integer.MAX_VALUE;
            //当前区间最大结束坐标
            int endIndex = jobDifficulty.length - d;
            //从当前坐标循环到最大结束坐标
            for(int i = curIndex; i <= endIndex; i++){
                //更新当前区间最大值
                curMaxDifficulty = Math.max(curMaxDifficulty, jobDifficulty[i]);
                //如果剩余天数大于一，说明可以继续分组
                if(d > 1){
                    //                  当前区间最大难度 + 后面部分的最优解
                    res = Math.min(res, curMaxDifficulty + helper(jobDifficulty, i + 1, d - 1));
                }
            }

            //如果剩余天数为一，那么最优解就是当前区间的最大难度
            if(d == 1)
                res = curMaxDifficulty;

            //保存最优解
            memo[curIndex][d] = res;
            //返回最优解
            return res;
        }
    }
}
