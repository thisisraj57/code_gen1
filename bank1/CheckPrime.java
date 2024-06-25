public class CheckPrime {

    public static boolean isPrime(int n) {
        // If n is less than or equal to 1, it is not prime
        if (n <= 1) {
            return false;
        }

        // Iterate through all numbers from 2 to the square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // If n is divisible by any number from 2 to its square root, it is not prime
            if (n % i == 0) {
                return false;
            }
        }

        // If n is divisible by no number from 2 to its square root, it is prime
        return true;
    }

    public static void main(String[] args) {
        // Test the isPrime method for a few numbers
        System.out.println(isPrime(1)); // false
        System.out.println(isPrime(2)); // true
        System.out.println(isPrime(9)); // false
        System.out.println(isPrime(23)); // true
    }
}