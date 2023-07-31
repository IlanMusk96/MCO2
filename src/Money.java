/**
 * Author: Ilan Templa
 * Class representation of money
 */
public class Money {
    /**
     * Constructor for money
     * @param value the value of the money
     */
    Money(int value){
        this.value = value;
        amt = 10;
    }

    /**
     * Method for adding to the amount of money
     * @param amt
     */
    public void addMoney(int amt)
    {
        this.amt+=amt;
    }

    /**
     * Method for taking away from the quantity of money
     * @param amt the amount of money to be taken away
     */
    public void takeMoney(int amt)
    {
        this.amt -= amt;
    }

    /**
     * Method for getting the value of the money
     * @return the value of the money
     */
    public int getValue(){return value;}

    /**
     * Method for getting the amt of money
     * @return the amount of money
     */
    public int getAmt() {
        return amt;
    }

    private final int value;
    private int amt;
}
