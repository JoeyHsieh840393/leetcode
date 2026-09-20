public class Q29 {
    public static int divide(int dividend, int divisor) {
        boolean isPositive = (dividend < 0) == (divisor < 0);
        long unsignDividend = Math.abs(dividend);
        long unsignDivisor = Math.abs(divisor);
        int result = 0;
        while (unsignDividend >= unsignDivisor) {
            int q = 0;
            long div = unsignDivisor;
            while (unsignDividend >= div << 1 ) {
                q++;
            }
            unsignDividend -= unsignDivisor << q;
            result += 1 << q;
        }


        return isPositive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(7, -2));
    }
}
