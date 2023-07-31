import java.util.ArrayList;

public class SpecialItem extends Item{

    public SpecialItem(String name, int price, double calories)
    {
        super(name, price, calories);
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Item ingredient)
    {
        ingredients.add(ingredient);
    }

    private ArrayList<Item> ingredients;
}
