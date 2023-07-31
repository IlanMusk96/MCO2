/**
 * Author: Ilan Templa
 * Class representation of an item in a vending machine
 */
public class Item {
    /**
     * Constructor for item
     * @param name the name of the item
     * @param price the price of the item
     * @param calories the calories of the item
     */
    public Item(String name, int price, double calories)
    {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Method for changing the item's price
     * @param price new price of item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Method for getting the item's name
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for getting the item's price
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Method for getting the item's calories
     * @return the calories of the item
     */
    public double getCalories() {
        return calories;
    }

    private String name;
    private int price;
    private double calories;
}
