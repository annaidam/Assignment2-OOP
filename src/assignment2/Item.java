package assignment2;

/*
Example:
Item potion = new Item(“Potion”, 20, 15.3);
Item hyperPotion = new Item(“Hyper Potion”, 50, 15.3);
//Assume that Vulpix has 50 MAX HP, and is currently at HP = 0.
System.out.println( vulpix.getHP() ) // HP = 0
vulpix.useItem(potion);
System.out.println( vulpix.getHP() ) // 0 + 20 = 20 HP
vulpix.useItem(hyperPotion);
System.out.println( vulpix.getHP() );
// 20 + 50 = 50 HP - Vulpix’s HP cannot go beyond 50.*/
public class Item {
    /* Pokemon can use items to heal their health points. Each item has a name, a healing power
    value (integer) and a weight (double). Once created, these values cannot be changed.*/
    private String name;
    private int healing_power;
    private double weight;

    public Item(String name, int healing_power, double weight) {
        this.healing_power = healing_power;
        this.name = name;
        this.weight = weight;
    }

    public String getItemName()
    {
        return name;
    }

    public int getHealing_power()
    {
        return healing_power;
    }

    public double getItemWeight()
    {
        return weight;
    }

    /*Two items are equals if they have the same name, healing power and weight values. When
    printed, an item should return "<item name> heals <heal power> HP. (<weight>)"*/
    public boolean equals(Object anotherItem) {
        if (anotherItem == null) {
            return false;
        } else if (anotherItem instanceof Item) {
            Item otherItem = (Item) anotherItem;
            if ((this.name.equals(otherItem.name)) && (this.healing_power == otherItem.healing_power) && (this.weight == otherItem.weight)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /*When printing the weight, you must truncate the weight to a precision of two decimals.
    Remember that truncating is not rounding.
    Recommendations: You don’t need to use DecimalFormat or RoundPrecision to truncate.
    You could also use the function String.format(...) similarly to
    System.out.printf.*/
    public String toString() {
        String item = this.getItemName() + " heals " + getHealing_power() + " HP. (" + (getItemWeight()%.2f) + ")";
        return item;
    }
}