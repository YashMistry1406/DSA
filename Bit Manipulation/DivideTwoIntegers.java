import java.util.*;

public class DivideTwoIntegers {
    /*
     * Function to divide two numbers
     * without multiplication and division
     */
    public int divideBruteForce(int dividend, int divisor) {

        // Base case
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;

        // Variable to store the sign of result
        boolean isPositive = true;

        // Updating the sign of quotient
        if (dividend >= 0 && divisor < 0)
            isPositive = false;
        else if (dividend < 0 && divisor > 0)
            isPositive = false;

        // Storing absolute dividend & divisor
        long n = dividend;
        long d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);

        // Variable to store the answer and sum
        long ans = 0, sum = 0;

        /*
         * Looping while sum added to divisor is
         * less than or equal to dividend
         */
        while (sum + d <= n) {

            // Increment the count
            ans++;
            // Update the sum
            sum += d;
        }

        // Handling overflowing condition
        if (ans > Integer.MAX_VALUE && isPositive)
            return Integer.MAX_VALUE;
        if (ans > Integer.MAX_VALUE && !isPositive)
            return Integer.MIN_VALUE;

        /*
         * Returning the quotient
         * with proper sign
         */
        return isPositive ? (int) ans : (int) (-1 * ans);
    }

    // ------------------------------OPTIMAL---------------------------------------------
    //
    //
    //
    // OPTIMAL SOLUTION USING BIT MANIPULATION
    public int divide(int dividend, int divisor) {
        // Handle edge case for 32-bit signed integer overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 1. Determine the sign of the final result
        boolean isPositive = (dividend < 0) == (divisor < 0);

        // 2. Convert both numbers to positive 64-bit longs to safely avoid 32-bit
        // overflow.
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // 6. Repeat until the dividend becomes smaller than the divisor
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // 3 & 4. Use bit shifting to find the largest multiple of the divisor
            while ((tempDivisor << 1) <= absDividend) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // 5. Subtract this multiple and accumulate the power of two
            absDividend -= tempDivisor;
            result += multiple;
        }

        // 7 & 8. Apply the correct sign and clamp limits implicitly handled
        return isPositive ? result : -result;
    }

}
