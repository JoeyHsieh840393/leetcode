public class Q29 {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = (dividend < 0) == (divisor < 0);
        long unsignDividend = Math.abs((long) dividend);
        long unsignDivisor = Math.abs((long) divisor);
        int result = 0;
        while (unsignDividend >= unsignDivisor) {
            int q = 0;
            long div = unsignDivisor;
            while (unsignDividend >= div << 1) {
                q++;
                div <<= 1;
            }
            unsignDividend -= div;
            result += 1 << q;
        }

        return isPositive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(7, -2));
    }
}
