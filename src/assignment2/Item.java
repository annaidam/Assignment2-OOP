package assignment2;

public class Item {
    private final String NAME;
    private final int HEALING_POWER;
    private final double WEIGHT;

    public Item(String name, int healing_power, double weight) {
        this.HEALING_POWER = healing_power;
        this.NAME = name;
        this.WEIGHT = weight;
    }

    public String getItemName()
    {
        return NAME;
    }

    public int getHealing_power()
    {
        return HEALING_POWER;
    }

    public double getWeight()
    {
        return WEIGHT;
    }

    public boolean equalItemName(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.getItemName().equals(otherItem.getItemName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalHealingPower(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.HEALING_POWER == otherItem.HEALING_POWER) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equalItemWeight(Object anotherItem) {
        Item otherItem = (Item) anotherItem;
        if (this.WEIGHT == otherItem.WEIGHT) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object anotherItem) {
        if (anotherItem == null) {
            return false;
        } else if (anotherItem instanceof Item) {
            if (equalItemName(anotherItem) && equalHealingPower(anotherItem) && equalItemWeight(anotherItem)) {
                return true;
            }
        }
        return false;
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