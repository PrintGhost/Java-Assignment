import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // this part of the code checks if there is one command line argument else the following text will be printed.
        if (args.length < 1) {
            System.out.println("Usage: java Main <command> [arguments]");
            return;
        }

        // switch statement checks the command; if it's not recognized, then the unknown command text will be printed.
        switch (args[0]) {
            case "removeVowels":
                if (args.length == 2) {
                    String result = removeVowels(args[1]);
                    System.out.println(result);
                } else {
                    System.out.println("Usage: java Main removeVowels <inputString>");
                }
                break;

            case "countStringOccurrences":
                if (args.length >= 3) {
                    String targetString = args[1];
                    String[] stringArray = Arrays.copyOfRange(args, 2, args.length);
                    int count = countStringOccurrences(stringArray, targetString);
                    System.out.println(count);
                } else {
                    System.out.println("Usage: java Main countStringOccurrences <targetString> <arrayOfStrings>");
                }
                break;

            case "sumRows":
                if (args.length >= 4) {
                    int width = Integer.parseInt(args[1]);
                    int height = Integer.parseInt(args[2]);
                    int[][] matrix = new int[height][width];

                    try {
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                matrix[i][j] = Integer.parseInt(args[i * width + j + 3]);
                            }
                        }

                        int[] rowSums = sumRows(matrix);
                        System.out.println(Arrays.toString(rowSums));
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Invalid input");
                    }
                } else {
                    System.out.println("Usage: java Main sumRows <width> <height> <row1> <row2> ...");
                }
                break;

            default:
                System.out.println("Unknown command: " + args[0]);
                break;
        }
    }

    // this part of the code removes all kinds of vowels.
    public static String removeVowels(String inputString) {
        return inputString.replaceAll("[aeiouAEIOU]", "");
    }

    // this part of the code counts the string in the array.
    public static int countStringOccurrences(String[] stringArray, String targetString) {
        int count = 0;
        for (String str : stringArray) {
            if (str.equals(targetString)) {
                count++;
            }
        }
        return count;
    }

    // this part of the code calculates the sum of the elements in every row in the array.
    public static int[] sumRows(int[][] matrix) {
        int[] rowSums = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowSums[i] += matrix[i][j];
            }
        }
        return rowSums;
    }
}

