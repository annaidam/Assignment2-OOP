package assignment2;

public class Item {
    String name;
    int healing_power;
    double weight;

    public Item() {
    }

    public Item(String name, int healing_power, double weight) {
        this.healing_power = healing_power;
        this.name = name;
        this.weight = weight;
    }

    String getName()
    {
        return name;
    }

    int getHealing_power()
    {
        return healing_power;
    }

    double getWeight()
    {
        return weight;
    }

    void printItem()
    {
        System.out.printf("\n %s heals %d HP. (%.2f)",name, healing_power, weight);
    }
}