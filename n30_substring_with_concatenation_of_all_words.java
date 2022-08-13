package leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class n30_substring_with_concatenation_of_all_words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList();
        Map<String, Integer> map = new HashMap();
        //每个单词的长度(每个单词长度相同)
        int wordLen = words[0].length();
        //单词的总数
        int wordCount = words.length;
        //拼接的substring的长度 = 单词长度*单词总数
        int subLen = wordLen * wordCount;
        //要遍历的字符串长度
        int n = s.length();
        //将每个单词放进hashmap里，统计词频
        for(String word : words)
            //getOrDefault(key, defaultValue)方法表示如果能获取key的value，则返回value,否则返回default value
            map.put(word, map.getOrDefault(word, 0) + 1);

        //遍历字符串s
        for(int i = 0; i < n - subLen + 1; ++i){
            //对于每次循环，先截取拼接字符串的长度
            String sub = s.substring(i, i + subLen);
            //创建一个临时的hashmap用于记录该循环下的拼接字符串里的各个词频
            Map<String, Integer> temp = new HashMap();
            //内层循环就是统计该循环下的拼接字符串里的各个词频
            for(int j = i; j < i + subLen; j = j + wordLen){
                //截取单词
                String subword = s.substring(j, j + wordLen);
                //如果这个单词根本没有出现在单词表上，说明这个拼接的字符串不符合要求，直接回到外层循环
                if(!map.containsKey(subword)) break;
                temp.put(subword, temp.getOrDefault(subword, 0) + 1);
            }
            //如果临时的统计词频和原来的相同，则加入答案
            if(temp.equals(map)) list.add(i);
        }
        return list;
    }
}
