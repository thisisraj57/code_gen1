public class Palindrome {

    public static boolean isPalindrome(String str) {
        // Convert the string to lowercase and remove all non-alphanumeric characters
        String cleanedStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Check if the modified string is empty or has only one character
        if (cleanedStr.isEmpty() || cleanedStr.length() == 1) {
            return true;
        }

        // Compare the string with its reverse
        return cleanedStr.equals(new StringBuilder(cleanedStr).reverse().toString());
    }

    public static void main(String[] args) {
        String testString = "racecar";
        boolean isPalindrome = isPalindrome(testString);
        System.out.println("Is '" + testString + "' a palindrome? " + isPalindrome);
    }
}