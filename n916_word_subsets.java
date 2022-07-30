package leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.List;

public class n916_word_subsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        //将word2转换成为一个单词，这个单词就是每个字母出现次数最高的组合体
        int[] bmax = count("");
        for (String b: words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        //进行对比
        for (String a: words1) {
            int[] aCount = count(a);
            int i = 0;
            //如果某个字母数量小于统计出来的字母，说明不符合直接break
            for (; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    break;
            //符合要求的单词加入集合
            if(i == 26) ans.add(a);
        }

        return ans;
    }

    //统计每个字母的出现次数
    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}


