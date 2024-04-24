import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // asking the user to give a string
        System.out.println("Give string:");
        String inputString = scanner.nextLine();

         // asking the user which character he/she wants to find
        System.out.println("Give character:");
        char searchCharacter = scanner.next().charAt(0);


        // using loop to find the character as commanded by teacher
        int foundPosi = -1;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == searchCharacter) {
                foundPosi = i;
                break; // using "break" to break the loop once character is found by the code
            }
        }


        // if character is found then it will print the result or it will print no '' characters found from the given string
        if (foundPosi != -1) {
            System.out.println("the first '" + searchCharacter + "' character was found in index " + foundPosi);
        } else {
            System.out.println("no '" + searchCharacter + "' characters found in the given string");
        }

        // closing the scanner
        scanner.close();
    }
}
    