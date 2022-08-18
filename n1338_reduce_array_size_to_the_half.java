package leetcode.dailychallenge;

import java.util.Arrays;

public class n1338_reduce_array_size_to_the_half {
    public int minSetSize(int[] arr) {
        //求得原数组一半的长度
        int half = arr.length / 2;
        //建一个hashmap,题意表示arr[i]的范围是[1,100000]
        int[] count = new int[100001];
        //声明最小与最大值的索引，以此减少遍历次数
        int minIndex = 100001;
        int maxIndex = 0;
        //统计
        for(int num : arr){
            count[num]++;
            minIndex = Math.min(minIndex, num);
            maxIndex = Math.max(maxIndex, num);
        }

        //根据索引进行排序
        Arrays.sort(count, minIndex, maxIndex);
        //声明相关变量
        int size = 0;
        int sum = 0;
        //从大到小，用贪心算法
        for(int i = maxIndex; i >= minIndex; i--){
            size++;
            sum += count[i];
            //如果超过或等于一半长度，返回结果
            if(sum >= half) return size;
        }
        return -1;
    }
}
