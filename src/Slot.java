import java.util.ArrayList;

public class Slot {

    public Slot(Item heldItem, int itemCap)
    {
        this.heldItem = heldItem;
        this.itemCap = itemCap;
        this.itemAmt = 15;
    }

    public Item dispense()
    {
        if (itemAmt > 0)
        {
            items.remove(itemAmt - 1);
            itemAmt--;
            return heldItem;
        }

        else
            return null;
    }

    public void restock(int amt)
    {
        for (int i = 0; i < amt&&items.size()<=itemCap; i++)
        {
            items.add(heldItem);
            itemAmt++;
        }
    }

    public void setHeldItem(Item heldItem) {
        this.heldItem = heldItem;
    }

    public void setPrice(int newPrice)
    {
        heldItem.setPrice(newPrice);

        for (int i = 0; i < itemAmt; i++)
            items.get(i).setPrice(newPrice);
    }

    public String getItemName() {
        return heldItem.getName();
    }

    public int getItemPrice() {
        return heldItem.getPrice();
    }

    public double getItemCalories() {
        return heldItem.getCalories();
    }

    public int getItemAmt() {
        return itemAmt;
    }

    public Item getHeldItem() {
        return heldItem;
    }

    private ArrayList<Item> items;
    private int itemAmt;
    private int itemCap;
    private Item heldItem;
}
