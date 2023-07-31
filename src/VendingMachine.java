import java.util.ArrayList;

/**
 * Author: Ilan Templa
 * This class represents a vending machine which can dispense items and has many maintenance features.
 */
public class VendingMachine {
    public VendingMachine() {
        vcType = "Regular";
        slots = new ArrayList<>();
        startingInventory = new ArrayList<>(8);
        this.slotCapacity = 15;
        currentItemAmt = 8;
        money.add(new Money(1));
        money.add(new Money(5));
        money.add(new Money(10));
        money.add(new Money(20));
        money.add(new Money(50));
        money.add(new Money(100));
        money.add(new Money(500));
        money.add(new Money(1000));
        slots.add(new Slot(new Item("Egg", 15, 196), 15));
        slots.add(new Slot(new Item("Rice", 20, 206), 15));
        slots.add(new Slot(new Item("Bacon", 60, 541), 15));
        slots.add(new Slot(new Item("Tocino", 50, 230), 15));
        slots.add(new Slot(new Item("Tapa", 50, 200), 15));
        slots.add(new Slot(new Item("Longganisa", 50, 220), 15));
        slots.add(new Slot(new Item("Tomato Slice", 3, 3), 15));
        slots.add(new Slot(new Item("Cucumber Slice", 3, 16), 15));
    }

    /**
     * This method restocks all the items in the vending the machine to full
     */
    public void restockAll()
    {
        for (Slot slot : slots) slot.restock(slotCapacity);
    }

    /**
     * This method restocks a specific slot to full
     * @param slotNum is the slot number where the item is in
     */
    public void restockItem(int slotNum)
    {
        slots.get(slotNum-1).restock(slotCapacity);
    }

    public void restockItem(int slotNum, int amt)
    {
        slots.get(slotNum-1).restock(amt);
    }

    /**
     * This method is for dispensing an item in the vending machine
     * @param slotNum is the slot number where the item is in
     * @param payment payment is the denomination that was used
     * @return true if item was dispensed successfully and false if not
     */

    public boolean dispenseItem(int slotNum, int payment)
    {
        slotNum -= 1;
        if(slots.get(slotNum).getItemAmt()==0)
            System.out.println("Out of stock");

        else if (payment<slots.get(slotNum).getItemPrice())
            System.out.println("Insufficient payment");

        else if (findEnoughChange(payment - slots.get(slotNum).getItemPrice())<payment - slots.get(slotNum).getItemPrice())
            System.out.println("Machine can not give change");

        else if(payment==slots.get(slotNum).getItemPrice()){
            slots.get(slotNum).dispense();
            receiveMoney(slots.get(slotNum).getItemPrice());
            System.out.println("You have received " + slots.get(slotNum).getItemName());
        }

        else if(slots.get(slotNum).getItemAmt()>0&&payment>=slots.get(slotNum).getItemPrice()
                 &&findEnoughChange(payment - slots.get(slotNum).getItemPrice())>=payment - slots.get(slotNum).getItemPrice())
         {
             slots.get(slotNum).dispense();
             receiveMoney(slots.get(slotNum).getItemPrice());
             System.out.print("You have received " + slots.get(slotNum).getItemName() + " and ");
             giveChange(payment, slots.get(slotNum).getItemPrice());
             return true;

         }

         return false;
    }

    /**
     * Method for changing the price of an item
     * @param slotNum is the number of the slot which will have a new price
     * @param newPrice is the new price of the item
     */
    public void changeSlotPrice(int slotNum, int newPrice)
    {
        slots.get(slotNum-1).setPrice(newPrice);
        startingInventory.get(slotNum-1).setPrice(newPrice);
        restockItem(slotNum);
    }

    /**
     * Method for taking all the money in the vending machine
     */
    public void takeVCMoney()
    {
        for (int i = 0; i < money.size(); i++)
            money.get(i).takeMoney(money.get(i).getAmt());
    }

    /**
     * Method for adding money to a specific denomination
     * @param amt amt of bills or coins to be added
     * @param denominationInd the index of the denomination in the Money array
     */
    public void addVCMoney(int amt, int denominationInd)
    {
        money.get(denominationInd - 1).addMoney(amt);
    }

    /**
     * Method for taking the money for a payment
     * @param itemPrice is the price of the item being bought
     */
    public void receiveMoney(int itemPrice)
    {
        int moneyQty = 0;

        for(int i = money.size() - 1; i >= 0 && itemPrice > 0 ; i--)
        {
            if(itemPrice >= money.get(i).getValue())
            {
                moneyQty = itemPrice/money.get(i).getValue();
                money.get(i).addMoney(moneyQty);
                itemPrice = itemPrice % money.get(i).getValue();
            }
        }
    }

    /**
     * Method for giving change after a purchase
     * @param payment is the payment for the purchase
     * @param itemPrice is the price of the item being purchased
     * @return true if able to give change false if not
     */
    public boolean giveChange(int payment, int itemPrice)
    {
        ArrayList<String> allChange = new ArrayList<>();
        int moneyQty;
        payment -= itemPrice;

        if(payment <= findEnoughChange(payment))// checks if there is enough money for the change
            for(int i = money.size() - 1; i >= 0 && payment != 0 ; i--)
            {
                if(payment >= money.get(i).getValue() && money.get(i).getAmt() != 0)//if the money value is equal or less than the payment ad if there is still money
                {
                    if(money.get(i).getAmt() * money.get(i).getValue() >= payment) {//if all the money in the denomination adds up as more than or equal to the payment
                        moneyQty = payment / money.get(i).getValue();//how many bills or coins will be needed as changed
                        money.get(i).takeMoney(moneyQty);//takes the amount of bills or coins
                        payment = payment % money.get(i).getValue();//decreases the amount of change now needed and moves to the next denomination
                    }

                    else
                    {//if the denomination does not add up to more than or equal to the required change
                        payment -= money.get(i).getAmt() * money.get(i).getValue();//gets all of the amount of denom as possible and decreases the change
                        moneyQty = money.get(i).getAmt();
                        money.get(i).takeMoney(moneyQty);//takes all the bills or coins from the denom
                    }

                    if(moneyQty == 1 && money.get(i).getValue() <=10)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " coin, ");

                    else if (moneyQty == 1 && money.get(i).getValue() >=20)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " bill, ");

                    else if (moneyQty > 1 && money.get(i).getValue() >=20)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " bills, ");

                    else if (moneyQty >= 1 && money.get(i).getValue() <=10)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " coins, ");
                }

                if(payment == 0) {
                    String allChange2 = "";
                    for (String s : allChange)
                        allChange2 += s;
                    allChange2 = allChange2.substring(0, allChange2.lastIndexOf(","));
                    System.out.println(allChange2);

                }
            }
        return payment==0;
    }

    /**
     * Method for giving change when no item is bought
     * @param payment is the money to be turned into change
     * @return true if able to give change or false if not
     */
    public boolean giveChange(int payment)
    {
        ArrayList<String> allChange = new ArrayList<>();
        int moneyQty;

        if(payment <= findEnoughChange(payment))
            for(int i = money.size() - 1; i >= 0 && payment != 0 ; i--)
            {
                if(payment > money.get(i).getValue() && money.get(i).getAmt() != 0)
                {
                    if(money.get(i).getAmt() * money.get(i).getValue() > payment) {
                        moneyQty = payment / money.get(i).getValue();
                        money.get(i).takeMoney(moneyQty);
                        payment = payment % money.get(i).getValue();
                    }

                    else
                    {
                        payment -= money.get(i).getAmt() * money.get(i).getValue();
                        moneyQty = money.get(i).getAmt();
                        money.get(i).takeMoney(moneyQty);
                    }

                    if(moneyQty == 1 && money.get(i).getValue() <=10)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " coin, ");

                    else if (moneyQty == 1 && money.get(i).getValue() >=20)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " bill, ");

                    else if (moneyQty > 1 && money.get(i).getValue() >=20)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " bills, ");

                    else if (moneyQty >= 1 && money.get(i).getValue() <=10)
                        allChange.add( moneyQty + " ₱" + money.get(i).getValue() + " coins, ");
                }

                if(payment == 0) {
                    String allChange2 = "";
                    System.out.print("You have received: ");
                    for (String s : allChange)
                        allChange2 += s;
                    allChange2 = allChange2.substring(0, allChange2.lastIndexOf(","));
                    System.out.println(allChange2);

                }
            }
        return payment==0;
    }

    /**
     * Method for displaying all the slots and their contents information
     */
    public void displaySlots()
    {
        for(int i = 0; i<currentItemAmt; i++)
            System.out.println("Slot " + (i+1) + ". Item: " + slots.get(i).getItemName() + " Price: ₱" + slots.get(i).getItemPrice() + " Amount: " + slots.get(i).getItemAmt()
                    + " Calories: " + slots.get(i).getItemCalories());
    }

    /**
     * Method for displaying the starting inventory
     */
    public void displayStartingInventory()
    {
        System.out.println("Starting Inventory: ");

        for(int i = 0; i<currentItemAmt; i++)
            System.out.println("Slot " + (i+1) + ". Item: " + startingInventory.get(i).getItemName()
                    + " Amount: " + startingInventory.get(i).getItemAmt());
    }

    /**
     * Method for displaying the current inventory
     */
    public void displayCurrentInventory()
    {
        System.out.println("Current Inventory: ");

        for(int i = 0; i<currentItemAmt; i++)
            System.out.println("Slot " + (i+1) + ". Item: " + slots.get(i).getItemName()
                    + " Amount: " + slots.get(i).getItemAmt());
    }

    /**
     * Method for displaying the transaction history
     */
    public void displayTransactionHistory()
    {
        int totalSales, i;
        int totalProfit = 0;

        System.out.println("Transaction History: ");
        for(i = 0; i<currentItemAmt; i++)
        {
            totalSales = startingInventory.get(i).getItemAmt()-slots.get(i).getItemAmt();
            System.out.println((i+1) + ". " + slots.get(i).getItemName() + ": " + totalSales + " sold.");
            totalProfit += slots.get(i).getItemPrice() * totalSales;
        }
        System.out.println("Total Profit: " + totalProfit);
    }

    /**
     * Method for displaying all the money in the vending machine and its amount
     */
    public void displayMoney()
    {
        for(int i = 0; i < money.size(); i++)
        {
            System.out.println((i+1) + ". ₱" + money.get(i).getValue() + " Amount of bills/coins: " + money.get(i).getAmt());
        }
    }

    /**
     * Method for getting the vending machine name
     * @return the name of vending machine
     */
    public String getVcType() {
        return vcType;
    }

    /**
     * Method for getting the item in a slot
     * @param slotNum the slot number of where the item is
     * @return the item in the slot
     */
    public Item getItem(int slotNum)
    {
        return slots.get(slotNum-1).getHeldItem();
    }

    /**
     * Method for getting the slot capacity of the vending machine
     * @return the slot capacity of the vending machine
     */
    public int getSlotCapacity() {
        return slotCapacity;
    }

    /**
     * Method for getting the current item amount
     * @return the current item amount
     */
    public int getCurrentItemAmt(){return currentItemAmt;}

    public ArrayList<Money> getMoney() {
        return money;
    }

    /**
     * Method for checking if the vending machine has enough change for the
     * @param payment is the payment for a purchase
     * @return the amount of money the vending machine has for the payment
     */
    private int findEnoughChange(int payment)
    {
        int totalCash = 0;
        for(int i = 0; i < money.size(); i++) {
            if(money.get(i).getValue()<=payment)
                totalCash += money.get(i).getValue() * money.get(i).getAmt();
        }
        return totalCash;
    }


    private String vcType;
    protected ArrayList<Slot> slots;
    protected ArrayList<Slot> startingInventory;
    private int slotCapacity;
    private int currentItemAmt;
    protected ArrayList<Money> money = new ArrayList<Money>();
}
