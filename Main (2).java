public class Main {
    public static void main(String[] args) {

        // this part of the code works to know if it is provided with two command line argument.
        if (args.length == 2) {
            try {

                // this part of the code try to parse two command-line arguments as integers and represent the width and height.however if it fail then the error text will be printed.
                int width = Integer.parseInt(args[0]);
                int height = Integer.parseInt(args[1]);

                // if the parse become successful then it will call generateRectangle and create the 2D array.
                char[][] rectangle = generateRectangle(width, height);
                output(rectangle);
            } catch (NumberFormatException e) {
                System.out.println("Invalid arguments. Please provide valid integers for width and height.");
            }
        } else {
            System.out.println("Usage: java Main <width> <height>");
        }
    }

   
    
    public static char[][] generateRectangle(int width, int height) {

        // this part of the code check if the provided width and height are less than or eqaul to zero.if true than the folllowing text will be printed.
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero.");
        }

        // if the values are greater than zero then it will create 2D array.
        char[][] rectangle = new char[height][width];

        // Fill the rectangle with '-' characters
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                rectangle[i][j] = '-';
            }
        }

        // this part of the code will fill the border with 'x' characters
        for (int i = 0; i < height; i++) {
            
            //this part of the code is for left border
            rectangle[i][0] = 'x'; 
            
            //this part of the code is right border
            rectangle[i][width - 1] = 'x';

        }
        for (int j = 0; j < width; j++) {

            //this part of the code is top border
            rectangle[0][j] = 'x'; 
            
            //this part of the code is bottom border
            rectangle[height - 1][j] = 'x'; 
        }

        return rectangle;
    }

   
    public static void output(char[][] table) {
        for (char[] row : table) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}

