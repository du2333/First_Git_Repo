package leetcode.dailychallenge;

import java.util.PriorityQueue;

public class n871_minimum_number_of_refueling_stops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //如果油本来就够开到终点，不需要加油返回0
        if(startFuel >= target) return 0;

        int n = stations.length;
        //前一个加油站到起点的距离
        int pre = 0;
        //目前车的油量
        int fuel = startFuel;
        //加油的次数
        int ans = 0;
        //优先队列，从大到小，来排列油的多少
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->(b-a));
        //遍历加油站
        for(int i = 0; i < n; i++){
            //先算出从当前位置到这个加油站需要耗费的油量
            int cost = stations[i][0] - pre;
            //减去油量
            fuel -= cost;

            //如果油量不够，则取出最大的一桶油加上，直到够用
            while(fuel < 0 && !q.isEmpty()){
                fuel += q.poll();
                ans++;
            }

            //如果全部加完了还不够，则表示到达不了终点
            if(fuel < 0) return -1;

            //将当前加油站的油加入的队列中
            q.offer(stations[i][1]);
            //更新pre
            pre = stations[i][0];
        }

        //计算出最后一个加油站到终点的距离
        fuel = fuel - (target - pre);
        //如果油量不够，则取出最大的一桶油加上，直到够用
        while(fuel < 0 && !q.isEmpty()){
            fuel += q.poll();
            ans++;
        }
        //如果全部加完了还不够，则表示到达不了终点
        if(fuel < 0) return - 1;
        //返回加油的次数
        return ans;
    }
}
