package salestax;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Processes data to and from cart files
 */
public class CartProcessor extends DataManager {

    public static final String CART_SRC = "src/salestax/carts/"; //Location of Cart source directory
    private Scanner userinput; //User input scanner

    /**
     * CartProcessor Constructor
     *
     * @param sc scanner that scans user input
     */
    public CartProcessor(Scanner sc) {
        super();
        this.userinput = sc;
    }

    /**
     * Processes cart data from file and prints receipts to System
     */
    public void processCart() {
        System.out.println();
        super.src = fileSelector(CART_SRC + userinput.nextLine());
        System.out.println();
        Cart cart = cartBuilder();
        if (cart.hasItems()) cart.printReceipt();
        System.out.println();
    }

    /**
     * Processes all files in cart files in cart directory and receipts to System
     */
    public void processCartDir() {
        File[] directory = directory(CART_SRC);
        for (File file : directory) {
            System.out.println();
            System.out.println(file.getName());
            super.src = file;
            Cart cart = cartBuilder();
            if (cart.hasItems()) cart.printReceipt();
            System.out.println();
        }
    }

    /**
     * Creates cart from cart data file
     *
     * @return Cart from cart data file
     */
    private Cart cartBuilder() {
        ArrayList<Item> items = new ArrayList<>();
        Cart bcart = new Cart(items);
        try (Scanner scan = new Scanner(super.src)) {
            scan.useDelimiter(",");
            if (!scan.hasNext()) {
                System.out.println("File is empty.");
            }
            while (scan.hasNextLine()) {
                Item item = itemGenerator(scan);
                items.add(item);
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (NullPointerException e) {
            System.out.println("File Selection Error");
        }
        return bcart;
    }

    /**
     * Creates item from scanned information; designed to work with a delimiter
     *
     * @param scan Scanner to read item information
     * @return Item object from scanned information
     */
    private Item itemGenerator(Scanner scan) {

        Item item = null;
        try {
            int quan = Integer.parseInt(scan.next());
            String name = scan.next();
            double price = Double.parseDouble(scan.next());
            boolean tax = convertToBool(scan.next());
            boolean imp = convertToBool(scan.next());
            item = new Item(quan, name, price, tax, imp);
        } catch (Exception e) {
            System.out.println("Error Processing Item(s). Check Input File for Formatting Errors.");
        }
        return item;
    }

    /**
     * Generates cart data file from user provided input
     */
    public void cartFileGenerator() {
        System.out.println("<Enter Title for Cart File>");
        System.out.println("Example: example.txt");
        System.out.println("NOTE: If a cart already exist with this title, it will be overwritten.");

        try (PrintStream cartfile = new PrintStream(CART_SRC + userinput.nextLine())) {
            cartFileScript(cartfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Script used to generate cart files and collect user input
     *
     * @param cartfile File where cart data is saved
     */
    private void cartFileScript(PrintStream cartfile) {
        String yn;
        do {
            System.out.println("Name of item: ");
            String name = userinput.nextLine();
            System.out.println("Quantity: ");
            String quan = userinput.nextLine();
            System.out.println("Price (ex: 45.23): ");
            String price = userinput.nextLine();
            System.out.println("Is the item taxable?\n(Only Food, Medical Supplies, and Books are not " +
                    "taxable)\nEnter True or False: ");
            String tax = userinput.nextLine();
            System.out.println("Is the item Imported?\n Enter True or False: ");
            String imp = userinput.nextLine();
            try {
                Item test = new Item(Integer.parseInt(quan), name, Double.parseDouble(price),
                        convertToBool(tax), convertToBool(imp));
                cartfile.println(quan + "," + name + "," + price + "," + tax + "," + imp + ",");
                System.out.println("<Enter any key to add other item or n to save/exit>");
            } catch (Exception e) {
                System.out.println(e + "\nFollow the instructions provided.");
                System.out.println("<Enter any key to try again or n to exit>");
            }
            yn = userinput.next();
            userinput.nextLine();
        } while (!yn.equalsIgnoreCase("n"));
        System.out.println("Cart File Generated!");
        System.out.println();
    }

    /**
     * Converts String into boolean, as long as the string value is either "true" or "false" (not case sensitive)
     *
     * @param value string to be converted to boolean
     * @return true or false depending on the string value
     * @throws Exception if the string value is not "true" or "false
     */
    private Boolean convertToBool(String value) throws Exception{
        Exception NotTrueOrFalse = new Exception("NotTrueOrFalse: Value is not True of False");

        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
            return Boolean.valueOf(value);
        else{
            throw NotTrueOrFalse;
        }
    }
}
