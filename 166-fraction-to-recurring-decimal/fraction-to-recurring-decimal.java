import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        // Result is zero
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append('-');
        }

        // Use long to safely handle Integer.MIN_VALUE
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);

        long remainder = num % den;

        // Finite decimal
        if (remainder == 0) {
            return result.toString();
        }

        result.append('.');

        // remainder -> position in result
        Map<Long, Integer> seen = new HashMap<>();

        while (remainder != 0) {

            // Repeating remainder found
            if (seen.containsKey(remainder)) {
                int position = seen.get(remainder);
                result.insert(position, '(');
                result.append(')');
                break;
            }

            seen.put(remainder, result.length());

            remainder *= 10;

            result.append(remainder / den);

            remainder %= den;
        }

        return result.toString();
    }
}