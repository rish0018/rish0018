import java.util.Deque;
import java.util.LinkedList;

class PalindromeUsingDeque {
    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Create a deque
        Deque<Character> deque = new LinkedList<>();

        // Add all characters of the string to the deque
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        // Check for palindrome
        while (deque.size() > 1) {
            // Remove characters from both ends and compare
            if (deque.removeFirst() != deque.removeLast()) {
                return false; // If mismatch, not a palindrome
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String test1 = "radar";
        String test2 = "hello";
        String test3 = "level";

        System.out.println("\"" + test1 + "\" is palindrome: " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" is palindrome: " + isPalindrome(test2));
        System.out.println("\"" + test3 + "\" is palindrome: " + isPalindrome(test3));
    }
}
