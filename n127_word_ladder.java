package leetcode.dailychallenge;

import java.util.*;

//单词接龙
public class n127_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //使用hashset存储wordList, 这样搜索时间就是O(1)
        Set<String> set = new HashSet();
        for(String word : wordList)
            set.add(word);

        //如果endWord不在单词表里，直接返回0
        if(!set.contains(endWord)) return 0;

        //创建一个队列进行BFS
        Queue<String> q = new LinkedList();
        //将beginWord加入到队列中
        q.offer(beginWord);
        //初始长度设置为1
        int level = 1;

        //BFS
        while(!q.isEmpty()){
            //获取当前队列长度，确定遍历次数
            int q_size = q.size();
            //遍历队列
            for(int i = 0; i < q_size; ++i){
                //取出一个单词
                String currentWord = q.poll();
                //因为String不可以被修改，故先转换成char[]
                char[] charWord = currentWord.toCharArray();
                //遍历这个单词的字母
                for(int j = 0; j < currentWord.length(); ++j){
                    //先保存原来的字母
                    char originalChar = charWord[j];
                    //遍历26个字母
                    for(char c = 'a'; c <= 'z'; ++c){
                        //如果和原来字母一样，则跳过这个循环
                        if(originalChar == c) continue;
                        //修改字符
                        charWord[j] = c;
                        //组成新单词
                        String newWord = String.valueOf(charWord);
                        //若新单词就是endWord，则直接返回当前长度+1
                        if(newWord.equals(endWord)) return level + 1;
                        //若单词表包含这个单词，则把他加入到队列中，且在单词表中删除这个单词
                        if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                        //复原字母
                        charWord[j] = originalChar;
                    }
                }
            }
            //步进
            level++;
        }

        //若无法找到单词接龙，则返回0
        return 0;
    }
}
