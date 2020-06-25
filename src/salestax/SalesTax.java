package salestax;

import java.io.File;
import java.util.Scanner;

/**
 * Execution file for salestax package
 */
public class SalesTax {

    private static final String MENU_SRC = "src/salestax/menu.txt";//Location of menu file
    private static final String INTRO_SRC = "src/salestax/intro.txt"; //Location of instruction file
    private static DataManager intro = new DataManager(INTRO_SRC);//Introduction File
    private static DataManager menu = new DataManager(MENU_SRC);//Menu Option File


    /**
     * Execution method
     * @param args String array that passes arguments at Command Line
     */
    public static void main(String[] args) {
        intro.filePrinter();
        menu.filePrinter();
        switchMenu();
    }

    /**
     * Interacts with menu option choices from the user
     */
    public static void switchMenu(){
        Scanner scan = new Scanner(System.in);
        do {
            switch (scan.nextLine()) {
                case "1": // Processes Cart from Existing File
                    System.out.println("Enter File Name:");
                    (new CartProcessor(scan)).processCart();
                    menu.filePrinter();
                    break;
                case "2": //Generates a New Cart File
                    System.out.println();
                    (new CartProcessor(scan)).cartFileGenerator();
                    menu.filePrinter();
                    break;
                case "3": // Shows Carts within Cart Directory
                    System.out.println("Carts in Directory:");
                    File[] cfolder = (new DataManager().directory(CartProcessor.CART_SRC)); //Files in Cart Directory
                    for (File filename : cfolder) System.out.print(filename.getName() + "   ");
                    System.out.println();
                    menu.filePrinter();
                    break;
                case "4": // Process All Carts at Once
                    (new CartProcessor(scan)).processCartDir();
                    System.out.println();
                    menu.filePrinter();
                    break;
                case "5": // Exit
                    System.exit(0); // Added to make exit possible from first iteration
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } while (!scan.hasNext("5"));
    }

}
