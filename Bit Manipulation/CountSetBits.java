import java.util.*;

// Solution class containing the countSetBits function
class Solution {
    // Function to count the number of set bits (1s) in the binary representation of
    // n using Brian Kernighan's Algorithm
    public int countSetBits(int n) {
        int count = 0; // Variable to store the count of set bits

        // Step 1: While n is non-zero, turn off the rightmost set bit
        while (n > 0) {
            n &= (n - 1); // Turn off the rightmost set bit
            count++; // Increment the count
        }

        // Step 2: Return the count of set bits
        return count;
    }
}

// Main class to test the Solution class
public class CountSetBits {
    public static void main(String[] args) {
        int n = 29; // Example input for n (binary: 11101)

        Solution sol = new Solution();
        int result = sol.countSetBits(n);

        System.out.println("The number of set bits is: " + result);
    }
}
