public class SpecialVendingMachine extends VendingMachine{

    SpecialVendingMachine()
    {
        super();
        SpecialItem toci = new SpecialItem("Tocilog", 99, 651);
        SpecialItem bacsi = new SpecialItem("Bacsilog", 109, 962);
        SpecialItem longsi = new SpecialItem("Longsilog", 99, 641);
        SpecialItem tapsi = new SpecialItem("Tapsilog", 99, 620);
        tapsi.addIngredient(slots.get(0).getHeldItem());
        tapsi.addIngredient(slots.get(1).getHeldItem());
        tapsi.addIngredient(slots.get(3).getHeldItem());
        tapsi.addIngredient(slots.get(6).getHeldItem());
        tapsi.addIngredient(slots.get(7).getHeldItem());

        bacsi.addIngredient(slots.get(0).getHeldItem());
        bacsi.addIngredient(slots.get(1).getHeldItem());
        bacsi.addIngredient(slots.get(2).getHeldItem());
        bacsi.addIngredient(slots.get(6).getHeldItem());
        bacsi.addIngredient(slots.get(7).getHeldItem());

        slots.add(new Slot(toci, 15));
        slots.add(new Slot(bacsi, 15));
        slots.add(new Slot(longsi, 15));
        slots.add(new Slot(tapsi, 15));
    }
}
