import java.util.Scanner;
import java.util.ArrayList;

public class TurnintoInitials {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Character> firstLetter = new ArrayList<Character>();
        String fullName;
        while (true) {
            System.out.println("Enter Full Name: ");
            fullName = input.nextLine();
            if (fullName.charAt(0) !=  ' ') {
                firstLetter.add(fullName.charAt(0));
                System.out.println(fullName.charAt(0));
            }
            for (int i = 1; i < fullName.length(); i++) {
                if (fullName.charAt(i-1) == ' ') {
                    System.out.println(fullName.charAt(i));
                    firstLetter.add(fullName.charAt(i));
                }
            }
            for (int i = 0; i < firstLetter.size(); i++) {
                if (i == (firstLetter.size() - 1 )) {
                    System.out.println(firstLetter.get(i));
                } else {
                    System.out.print(firstLetter.get(i));
                }
            }
            firstLetter.clear();
        }
    }
}
