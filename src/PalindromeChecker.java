import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Character> charsList1 = new ArrayList<Character>();
        ArrayList<Character> charsList2 = new ArrayList<Character>();
        String palindromeString;
        while (true) {
            System.out.println("Enter a palindrome: ");
            input = new Scanner(System.in);
            palindromeString = input.nextLine().replace(" ", "");
            int palindromeStringLengthHalved = Math.round(palindromeString.length()/2);
            for (int i = 0; i < palindromeStringLengthHalved; i++) {
                charsList1.add(Character.toLowerCase(palindromeString.charAt(i)));
            }
            if (palindromeString.length() % 2 == 0) {
                for (int i = palindromeString.length() - 1; i >= palindromeStringLengthHalved; i--) {
                    charsList2.add(Character.toLowerCase(palindromeString.charAt(i)));
                }
            } else {
                for (int i = palindromeString.length() - 1; i > palindromeStringLengthHalved; i--) {
                    charsList2.add(Character.toLowerCase(palindromeString.charAt(i)));
                }
            }
            // System.out.println(charsList1); DEBUG
            // System.out.println(charsList2); DEBUG
            if (charsList1.equals(charsList2)) {
                System.out.println("It's a palindrome!");
            } else {
                System.out.println("Not a palindrome!");
            }
            charsList1.clear();
            charsList2.clear();
        }
    }
}
