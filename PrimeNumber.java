public class PrimeNumber {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter a number: ");
      int num = sc.nextInt();

      boolean isPrime = true;

      // Iterate from 2 to the square root of the number
      for (int i = 2; i <= Math.sqrt(num); i++) {
         // If the number is divisible by any number from 2 to its square root, it is not prime
         if (num % i == 0) {
            isPrime = false;
            break;
         }
      }

      if (isPrime) {
         System.out.println(num + " is a prime number.");
      } else {
         System.out.println(num + " is not a prime number.");
      }
   }
}