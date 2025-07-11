package brown;

import java.math.BigInteger;

public class DigitSum {
    private static final BigInteger SEVENTEEN = BigInteger.valueOf(17);
    private static final BigInteger TEN = BigInteger.TEN;
    
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        boolean allIsZeros = true;
        for (int d : A) {
            if (d != 0) {
                allIsZeros = false;
                break;
            }
        }
        if (allIsZeros) {
            return 0;
        }
        
        if (A.length == 1) {
            return sumDigits(BigInteger.valueOf(A[0] * 17));
        }
        
        BigInteger aNumber = convertToNumber(A);
        BigInteger result = aNumber.multiply(SEVENTEEN);
        return sumDigits(result);
    }
    
    private BigInteger convertToNumber(int[] A) {
        StringBuilder stringBuilder = new StringBuilder(A.length);
        
        for (int i = A.length - 1; i >= 0; i--) {
            stringBuilder.append(A[i]);
        }
        
        return new BigInteger(stringBuilder.toString());
    }
    
    private int sumDigits(BigInteger input) {
        if (input.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            long value = input.longValue();
            int sum = 0;
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
            return sum;
        }
        
        String digits = input.toString();
        int result = 0;
        
        for (int i = 0; i < digits.length(); i++) {
            result += digits.charAt(i) - '0';
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        DigitSum solution = new DigitSum();
        
        // Test case from the problem statement
        int[] A = {3, 5, 1};  // Represents 153
        int result = solution.solution(A);
        System.out.println("Sum of digits in 17*153: " + result);  // Should be 9
        
        // Additional test case
        int[] B = {9, 9, 9};  // Represents 999
        result = solution.solution(B);
        System.out.println("Sum of digits in 17*999: " + result);  // 17*999 = 16983, sum = 27
    }
}