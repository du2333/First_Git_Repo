package leetcode.dailychallenge;

public class n387_first_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        //创建一个字母表
        int[] arr = new int[26];
        int n = s.length();
        //统计各个字母的频率
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        //如果只出现一次就返回当前索引
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        //否则返回-1
        return -1;
    }
}
