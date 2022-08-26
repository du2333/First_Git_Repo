package leetcode.dailychallenge;

public class n383_ransom_note {
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        //store the frequency of each char in magazine
        for(int i = 0; i < magazine.length(); i++){
            hash[magazine.charAt(i) - 'a']++;
        }
        //traverse the ransomNote and decrease each time
        for(int i = 0; i < ransomNote.length(); i++){
            hash[ransomNote.charAt(i) - 'a']--;
            if(hash[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }
}
