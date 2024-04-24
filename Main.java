import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        // asking the user to give number 1 
        System.out.println("Give number 1:");
        double n1 = scanner.nextDouble();

        // asking the user to give operator
        System.out.println("Give operator (+,-,*,/):");
        char operator = scanner.next().charAt(0);

        // asking the user to give number 2
        System.out.println("Give number 2:");
        double n2 = scanner.nextDouble();

        // initial result is 0
        double result =0;

        // if there is any error
        boolean error = false;


        // using case to calculate
        switch (operator) {
            case '+':
              result= n1 + n2; 
                break;

                case '-':
                 result= n1 - n2; 
                break;

                case '*':
              result= n1 * n2; 
                break;
        
                case '/':

                // if the user put 0 for division then it will be a error and the result will be displayed
                if (n2==0){
                    error = true;
                    System.out.println("Error: Division by zero is not allowed.");

                 // if the user gives any number other thn 0 then calaculation will be done   
                }else {
                    result= n1 / n2; 
                }
                break;
            default:

            // if the user gives a invalid operator then this will be published as a result
            System.out.println("Error: Invalid operator.");
                break;
        }

        // displaying the results
        if (!error) {
            System.out.println("Result: " + result);
        }

        // closing the scanner
        scanner.close();
    }
}