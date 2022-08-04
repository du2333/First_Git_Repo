package leetcode.dailychallenge;

public class n858_mirror_reflection {
    public int mirrorReflection(int p, int q) {
        int g = gcd(q, p);
        //k1表示光的水平折射次数，如果是奇数表示在右边，偶数则左边
        int k1 = p / g;
        //k2表示光在竖直墙壁上的折射次数，奇数表示在上面，偶数表示在下面
        int k2 = (k1 * q) / p;

        if(k1 % 2 == 1 && k2 % 2 == 1) return 1;
        if(k1 % 2 == 1 && k2 % 2 == 0) return 0;
        else return 2;
    }

    //greatest common divisor, 求最大公约数
    public int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
