package salestax;

/**
 * Used to create and manage Item objects and their properties
 */
public class Item {

    private final double taxrate = 0.10; //tax rate
    private final double importtax = 0.05; //import tax rate

    private int quantity; //Number of item
    private String name; // Name of item
    private double price; // Price of item
    private boolean taxable; // Whether or not the item is taxable
    private boolean imported; // Whether or not the item is imported

    /**
     * Item Constructor
     *
     * @param quant number of identical items
     * @param nam   name of item
     * @param value price of item before tax
     * @param tax   is item taxable
     * @param impor is item imported
     */
    public Item(int quant, String nam, double value, boolean tax, boolean impor) {
        quantity = quant;
        name = nam;
        price = value;
        taxable = tax;
        imported = impor;
    }

    /**
     * @return the amount of applicable tax to item
     */
    public double itemTax() {
        double t = taxrate;
        if (!this.isTaxable())
            t = 0;
        if (this.isImportable())
            t += importtax;
        return taxRoundUp(this.getQuantityPrice() * t);
    }

    /**
     * @return the total cost of item with tax
     */
    public double getTotal() {
        return this.itemTax() + this.getQuantityPrice();
    }

    /**
     * @return quantity value of item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * @return price of single item before tax
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return price of item * the quantity of item
     */
    public double getQuantityPrice() {
        return price * quantity;
    }

    /**
     * @return whether or not an item is taxable
     */
    public boolean isTaxable() {
        return taxable;
    }

    /**
     * @return whether or not an item is imported
     */
    public boolean isImportable() {
        return imported;
    }

    /**
     * Rounds price value up to the nearest 0.05
     *
     * @param t item value after tax
     * @return item value after tax and applicable round up
     */
    private double taxRoundUp(double t) {
        return Math.ceil(t * 20) / 20.0;
    }
}
