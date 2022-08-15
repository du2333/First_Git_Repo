package leetcode.dailychallenge;

import java.util.HashMap;
import java.util.Map;

public class n13_roman_to_integer {
    //先创建一个hashmap来存储对应罗马字母的值
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        //遍历字符串
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            //如果当前罗马字母小于后面的罗马字母，则减去当前罗马字母
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {//反之就是相加
                ans += value;
            }
        }
        return ans;
    }
}
