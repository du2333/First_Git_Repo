package leetcode.dailychallenge;

import java.util.HashMap;
import java.util.Map;

public class n659_split_array_into_consecutive_subsequences {
    //nums is a non-decreasing order array
    public boolean isPossible(int[] nums) {
        //创建一个hashmap来统计每个数字的出现频率
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        //创建一个数组来统计以x结尾的一条连续子序列
        Map<Integer, Integer> endMap = new HashMap<>();
        for(int num : nums){
            //获取num的频率
            int count = countMap.getOrDefault(num, 0);
            //如果存在则
            if(count > 0){
                //查询是否存在以num-1结尾的子序列
                int preEndCount = endMap.getOrDefault(num - 1, 0);
                //如果存在
                if(preEndCount > 0){
                    //则将num的剩余使用次数-1
                    countMap.put(num, count - 1);
                    //新子序列以num结尾，添加到end里面去
                    endMap.put(num, endMap.getOrDefault(num , 0) + 1);
                    //以num-1结尾的子序列数量-1
                    endMap.put(num - 1, preEndCount - 1);
                }
                //如果不存在以num-1结尾的子序列
                else{
                    //则自己创建一条长度至少为3的连续子序列
                    //先获取num+1,num+2的剩余使用次数
                    int count1 = countMap.getOrDefault(num + 1, 0);
                    int count2 = countMap.getOrDefault(num + 2, 0);
                    //如果都可以用
                    if(count1 > 0 && count2 > 0){
                        //则把对应数字的使用次数-1
                        countMap.put(num, count - 1);
                        countMap.put(num + 1, count1 - 1);
                        countMap.put(num + 2, count2 - 1);
                        //并在end里添加以num+2结尾的子序列
                        endMap.put(num + 2, endMap.getOrDefault(num + 2 , 0) + 1);
                    }
                    //如果没有，则返回false
                    else return false;
                }
            }
        }

        return true;
    }
}
