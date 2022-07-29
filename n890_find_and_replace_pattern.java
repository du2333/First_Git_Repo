package leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class n890_find_and_replace_pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<String>();
        for(String word : words){
            //当word和pattern可以相互映射的时候，把word添加进答案list
           if(match(word, pattern) && match(pattern, word))
               ans.add(word);
        }

        return ans;
    }
    //match 方法用来确认word是否可以映射到pattern
    public boolean match(String word, String pattern){
        //如果他们长度不一，直接返回false
        if(word.length() != pattern.length()) return false;
        //创建一个map来记录映射关系
        Map<Character, Character> m = new HashMap<Character, Character>();

        for(int i = 0; i < word.length(); ++i){
            //首先找到每个字母
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            //如果在map中还没有此字母，那么创建字母c1和c2的映射关系键值对
            if(!m.containsKey(c1)){
                m.put(c1, c2);
            }
            //如果已经有了这个字母，但是发现c2不是先前c1的映射，说明word和pattern不能相互映射
            else if(m.get(c1) != c2) return false;
        }

        return true;
    }
}
