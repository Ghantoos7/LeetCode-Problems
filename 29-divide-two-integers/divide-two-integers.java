class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            // Special case to handle overflow
            return Integer.MAX_VALUE;
        }

        boolean differentSigns = (dividend < 0) ^ (divisor < 0);

        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long result = 0;
        while (longDividend >= longDivisor) {
            long temp = longDivisor, multiple = 1;
            while (longDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            longDividend -= temp;
            result += multiple;
        }

        return differentSigns ? -(int) result : (int) result;
    }
}
