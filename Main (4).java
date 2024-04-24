import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // this part of the code checks if there is one command line argument.
        if (args.length < 1) {
            System.out.println("Usage: java Main <command> [arguments]");
            return;
        }

        switch (args[0]) {

            // these are the cases for different commands
            case "findPalindromes":
                if (args.length > 1) {
                    String[] palindromes = findPalindromes(Arrays.copyOfRange(args, 1, args.length));
                    System.out.println(Arrays.toString(palindromes));
                } else {
                    System.out.println("Usage: java Main findPalindromes <string1> <string2> ...");
                }
                break;

            case "countStringsStartingWith":
                if (args.length >= 3) {
                    String character = args[1];
                    int count = countStringsStartingWith(Arrays.copyOfRange(args, 2, args.length), character);
                    System.out.println(count);
                } else {
                    System.out.println("Usage: java Main countStringsStartingWith <character> <string1> <string2> ...");
                }
                break;

            case "swapFirstAndLastCharacter":
                if (args.length == 2) {
                    String result = swapFirstAndLastCharacter(args[1]);
                    System.out.println(result);
                } else {
                    System.out.println("Usage: java Main swapFirstAndLastCharacter <inputString>");
                }
                break;

            default:
                System.out.println("Unknown command: " + args[0]);
                break;
        }
    }

    // this part of the code checks the array and keeps only palindromic strings.
    public static String[] findPalindromes(String[] stringArray) {
        return Arrays.stream(stringArray)

                // this part of the code checks if the string is a palindrome.
                .filter(Main::isPalindrome)
                .toArray(String[]::new);
    }

    // this part of the code counts the number of strings in the array that start with a specified character.
    public static int countStringsStartingWith(String[] stringArray, String character) {
        char firstChar = character.charAt(0);
        return (int) Arrays.stream(stringArray)
                .filter(s -> s.charAt(0) == firstChar)
                .count();
    }

    // this part of the code swaps the first and last characters of the input string.
    public static String swapFirstAndLastCharacter(String inputString) {

        // Implementation here
        if (inputString.length() <= 1) {
            return inputString;
        }

        char[] charArray = inputString.toCharArray();
        char firstChar = charArray[0];
        charArray[0] = charArray[charArray.length - 1];
        charArray[charArray.length - 1] = firstChar;

        return new String(charArray);
    }

    // this part of the code checks if there is a string is a palindrome.
    private static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleanedStr.equals(new StringBuilder(cleanedStr).reverse().toString());
    }
}
