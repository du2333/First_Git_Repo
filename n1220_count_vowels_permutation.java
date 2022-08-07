package leetcode.dailychallenge;

public class n1220_count_vowels_permutation {
    public int countVowelPermutation(int n) {
        int MOD = (int)1e9 + 7;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        //从长度为2的字符串开始
        for(int j = 2; j <= n; ++j){
            //每个元音 'a' 后面都只能跟着 'e'
            long aa = e % MOD;
            //每个元音 'e' 后面只能跟着 'a' 或者是 'i'
            long ee = (a + i) % MOD;
            //每个元音 'i' 后面 不能 再跟着另一个 'i'
            long ii = (a + e + o + u) % MOD;
            //每个元音 'o' 后面只能跟着 'i' 或者是 'u'
            long oo = (i + u) % MOD;
            //每个元音 'u' 后面只能跟着 'a'
            long uu = a % MOD;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        return (int)((a + e + i + o + u) % MOD);
    }
}
