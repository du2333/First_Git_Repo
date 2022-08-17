package leetcode.dailychallenge;

import java.util.HashSet;
import java.util.Set;

public class n804_unique_morse_code_words {
    public int uniqueMorseRepresentations(String[] words) {
        //用hashset来去重
        Set<String> seen = new HashSet<>();
        for(String word : words){
            seen.add(toMorse(word));
        }
        return seen.size();
    }

    //将字符串转换成对应的莫斯码
    private String toMorse(String s){
       StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            result.append(getMorseCode(c));
        }
        return result.toString();
    }

    //获取26个字母对应的莫斯码
    private String getMorseCode(char c){
        return switch (c) {
            case 'a' -> ".-";
            case 'b' -> "-...";
            case 'c' -> "-.-.";
            case 'd' -> "-..";
            case 'e' -> ".";
            case 'f' -> "..-.";
            case 'g' -> "--.";
            case 'h' -> "....";
            case 'i' -> "..";
            case 'j' -> ".---";
            case 'k' -> "-.-";
            case 'l' -> ".-..";
            case 'm' -> "--";
            case 'n' -> "-.";
            case 'o' -> "---";
            case 'p' -> ".--.";
            case 'q' -> "--.-";
            case 'r' -> ".-.";
            case 's' -> "...";
            case 't' -> "-";
            case 'u' -> "..-";
            case 'v' -> "...-";
            case 'w' -> ".--";
            case 'x' -> "-..-";
            case 'y' -> "-.--";
            case 'z' -> "--..";
            default -> "";
        };
    }
}
