import java.math.BigInteger;

public class gcd {

    private int gcd_naive(int a, int b){

        for (int i = Math.min(a, b); i > 0; i--){
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 0;
    }


    private long gcd_euclid_rc(long a, long b) {
//        System.out.println(a + " " + b);
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd_euclid_rc(b % a, a);
    }

    private BigInteger gcd_euclid(BigInteger a, BigInteger b){
        while (true){
//            System.out.println(a + " " + b);
            if (a.equals(BigInteger.ZERO)) return b;
            if (b.equals(BigInteger.ZERO)) return a;
            BigInteger c = a;
            a = b.mod(a);
            b = c;
        }
    }
    private void run(){
        BigInteger a = new BigInteger("11411231235498675620865248754969707609674659753964");
        BigInteger b = new BigInteger("541231231938657042928765624364758945605987653435367");
        System.out.println(gcd_euclid(a, b));
        System.out.println(a.gcd(b));
        System.out.println(gcd_euclid_rc(1141123123549867564L, 5412312319386570428L));
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new gcd().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
