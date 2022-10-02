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

    public double getWeight()
    {
        return weight;
    }

    /*Two items are equals if they have the same name, healing power and weight values. When
    printed, an item should return "<item name> heals <heal power> HP. (<weight>)"*/

    /*
    public boolean equalItemName(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.getItemName().equals(otherItem.getItemName()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalHealingPower(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.getHealingPower() == otherItem.getHealingPower()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalItemWeight(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.getItemWeight == otherItem.getItemWeight) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object anotherItem {
        if (anotherItem == null) {
            return false;
        } else if (anotherItem instanceof Item) {
            Item otherItem = (Item) anotherItem;
            if (equalItemName(anotherItem) && equalHealingPower(anotherItem) && equalItemWeight(anotherItem) {
                return true;
            }
        }
        return false;
    }
     */
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

    public String truncateWeight() {
        String truncatedWeight = String.format("%.2f", Math.floor((Math.pow(10,2) * this.getWeight())) / Math.pow(10,2));
        return truncatedWeight;
    }

    public String toString() {
        String item = this.getItemName() + " heals " + this.getHealing_power() + " HP. (" + this.truncateWeight() + ")";
        return item;
    }
}