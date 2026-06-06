import java.util.*;

class CountGoodNumbers
{
    static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n)
    {
        long even = (n + 1) / 2, odd = n / 2;
        return (int) (modpow(5, even) * modpow(4, odd) % MOD);
    }

    long modpow(long base, long exp)
    {
        long res = 1;
        base %= MOD;
        while (exp > 0)
        {
            if ((exp & 1) == 1)
                res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}
