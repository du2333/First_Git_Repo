package leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n936_stamping_the_sequence {
    public static void main(String[] args) {
        /*
        *   1.Target = abababc
            2.Target = abab???  4
            3.Target = ab?????  2
            4.Target = ???????  0
        * */
        int[] res = movesToStamp("abc", "abababc");
        System.out.println(Arrays.toString(res));
    }
    public static int[] movesToStamp(String stamp, String target) {
        //反向思考，题目要求经过某种盖章手段，生成target字符串，我们反着来，怎样将target字符串变成空的
        char[] charArr = target.toCharArray();
        int n = target.length();
        int m = stamp.length();
        boolean[] visited = new boolean[n];
        List<Integer> ansList = new ArrayList<>();
        //已经覆盖过字母的数量
        int count = 0;
        //当计数器小于target长度时候
        while(count < n){
            //表示这次循环可以进行覆盖
            boolean flag = false;
            //遍历target
            for(int i = 0; i <= n - m; ++i){
                //当当前字母没有被访问过 以及 可以和stamp进行配队
                if(!visited[i] && isMatch(charArr, i, stamp)){
                    //就把当前字母到stamp长度后面的字母全部变成？
                    for(int j = 0; j < stamp.length(); ++j){
                        //如果当前字母不是?则改成?,计数器+1
                        if(charArr[i + j] != '?'){
                            count++;
                            charArr[i + j] = '?';
                        }
                    }
                    //将当前索引改成一访问
                    visited[i] = true;
                    //加入结果
                    ansList.add(i);
                    //将当前状态改成可以覆盖
                    flag = true;
                    //如果计数器等于target长度，说明已经完成转换
                    if(count == n) break;
                }
            }
            //如果当前不可以覆盖，则说明无法转换，返回空数组
            if(!flag) return new int[0];
        }


        //创建一个结果数组
        int[] ans = new int[ansList.size()];
        //将先前的结果反着添加进去
        for(int i = 0; i < ansList.size(); ++i){
            ans[i] = ansList.get(ansList.size() - i - 1);
        }

        return ans;

    }

    //对比stamp和当前索引
    private static boolean isMatch(char[] arr, int index, String stamp){
        //计数器
        int i = 0;
        //保证i + index不超过target长度 以及 i不超过stamp长度
        for(; i + index < arr.length && i < stamp.length(); ++i){
            //如果当前字母既不 匹配 也不是 ? 则表示匹配失败
            if(arr[index + i] != stamp.charAt(i) && arr[index + i] != '?') return false;
        }
        //如果计数器长度和stamp长度一样，则表示匹配成功
        return i == stamp.length();
    }
}
