package salestax;

import java.util.ArrayList;

/**
 * Used to create and manage Cart objects that hold Item objects
 */
public class Cart {
    private ArrayList<Item> items; //Array of Items in a given Cart

    /**
     * Cart Constructor
     *
     * @param items Items to be placed in Cart
     */
    public Cart(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * @return total amount of tax for items in Cart
     */
    private double totalTax() {
        double tax = 0;
        for (Item item : this.items) {
            tax = tax + item.itemTax();
        }
        return tax;
    }

    /**
     * @return total cost of items in Cart with tax
     */
    private double grandTotal() {
        double gtotal = 0;
        for (Item item : this.items) {
            gtotal = gtotal + item.getTotal();
        }
        return gtotal;
    }

    /**
     * Prints receipt with item data, total price, and total tax
     */
    public void printReceipt() {
        try {
            for (Item item : this.items) {
                System.out.print(item.getQuantity() + " ");
                System.out.print(item.getName() + ": ");
                System.out.println(String.format("%.2f", item.getTotal()));
            }
            System.out.println("Sales Taxes: " + String.format("%.2f ", this.totalTax()));
            System.out.println("Total: " + String.format("%.2f", this.grandTotal()));
        } catch (NullPointerException e) {
            System.out.print("Item data error.");
            return;
        }
    }

    /**
     * Determines whether or not a cart has items
     *
     * @return true if a cart has items, false if not
     */
    public boolean hasItems() {
        boolean hasitems = true;
        if ((this.items).isEmpty()) {
            hasitems = false;
        }
        return hasitems;
    }

}
