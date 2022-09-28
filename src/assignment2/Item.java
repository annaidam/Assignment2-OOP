package assignment2;

public class Item {
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

    public String toString() {
        String item = this.getItemName() + " heals " + getHealing_power() + " HP. (" + (getItemWeight()%.2f) + ")";
        return item;
    }
}