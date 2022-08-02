import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fib {

    private static final int MOD = (int)1e9 + 7;
//    Map<Integer, BigInteger> cache = new HashMap<>();
    List<BigInteger> cache = new ArrayList<>();
    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    List<Integer> cache2 = new ArrayList<>();
    {
        cache2.add(0);
        cache2.add(1);
    }

//    int cnt;
    private BigInteger fibonacci(int n) {
        //0 .. cache.size - 1
        //cache.size .. n
        for (int i = cache.size(); i <= n; i++) {
            BigInteger res = cache.get(i - 1).add(cache.get(i - 2));
            cache.add(i, res);
        }
        return cache.get(n);
    }

//        cnt++;
//        if (n <= 1){
//            return BigInteger.valueOf(n);
//        }
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        } else {
//            for (int i = 2; i <= n; i++){
//                BigInteger res = fib_naive(i - 1).add(fib_naive(i - 2));
//                cache.put(i, res);
//            }
//            return cache.get(n);
//        }
//

    private int fib_2(int n){
        for (int i = cache2.size(); i <= n; i++) {
            int res = (cache2.get(i - 1) + cache2.get(i - 2)) % MOD;
            cache2.add(res);
        }
        return cache2.get(n);
    }

    private int fib_3(int n){
        int f1 = 0;
        int f2 = 1;
        int temp;
        for (int i = 0; i < n - 1; i++){
            temp = f2;
            f2 = (f1 + f2) % MOD;
            f1 = temp;
        }
        return f2;
    }

    private void run(int n){
        System.out.println(n + ", " + fib_3(n));
//        System.out.println(cnt + " calls");
    }

    public static void main_(String[] args){
        for (int i = 15000; i < 15001; i++) {
            long startTime = System.currentTimeMillis();
            new fib().run(i);
            long finishTime = System.currentTimeMillis();
            System.out.println(finishTime - startTime + " ms");
        }
    }
}
