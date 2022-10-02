package assignment2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ItemBag {
    private final double MAX_BAG_WEIGHT;
    private double currentBagWeight;
    ArrayList<Item> itemBag = new ArrayList<>();

    public ItemBag(double maxBagWeight) {
        this.MAX_BAG_WEIGHT = maxBagWeight;
    }

    public int getNumOfItems() {
        if (this.itemBag.isEmpty()) {
            return 0;
        } else {
            return this.itemBag.size();
        }
    }

    public double getCurrentWeight() {
        currentBagWeight = 0;
        if (!this.itemBag.isEmpty()) {
            for (Item currentItem : itemBag) {
                currentBagWeight += currentItem.getWeight();
            }
        }
        double roundVal = Math.round(currentBagWeight * 100.0) / 100.0;
        return roundVal;
    }

    public double getMaxWeight() {return this.MAX_BAG_WEIGHT;}

    //we got help from a classmate with the addItem method
    public int addItem(Item newItem) {
        boolean itemAdded = false;
        if (currentBagWeight + newItem.getWeight() > MAX_BAG_WEIGHT) {
            return -1;
        }
        if (itemBag.isEmpty()) {
            itemBag.add(newItem);
        } else {
            for (int i = 0; i < itemBag.size(); i++) {
               if (!itemAdded) {
                   if (newItem.getWeight() >= itemBag.get(i).getWeight()) {
                       itemBag.add(i, newItem);
                       itemAdded = true;
                   } else if (i == itemBag.size() - 1) {
                       itemBag.add(newItem);
                       itemAdded = true;
                   }
               }
            }
        }
        currentBagWeight += newItem.getWeight();
        return this.itemBag.indexOf(newItem);
    }

    public Item removeItemAt(int index) {
        Item removedItem;
        for (int i = 0; i < this.itemBag.size(); i++) {
            if (index == i) {
                removedItem = itemBag.get(i);
                currentBagWeight -= removedItem.getWeight();
                itemBag.remove(i);
                for (int j = this.itemBag.size() - 1; j < i; j--) {
                    if (itemBag.get(i).getWeight() < itemBag.get(j).getWeight()) {
                        Item temporary = itemBag.get(i);
                        itemBag.set(i, itemBag.get(j));
                        itemBag.set(j, temporary);
                    }
                }
                return removedItem;
            }
        }
        return null;
    }

    public String peekItemAt(int index) {
        String peeking = "";
        boolean inBounds = (index >= 0) && (index < itemBag.size());
        for (int i = 0; i < this.itemBag.size(); i++) {
            Item currentItem = itemBag.get(i);
            if (index == i) {
                peeking = currentItem.toString();
            }
        }
        if (!inBounds) {
            return "";
        }
        return peeking;
    }

    public Item popItem() {
        Item heaviestItem;
        if (!itemBag.isEmpty()) {
            heaviestItem = itemBag.get(0);
            itemBag.remove(0);
        } else {
            return null;
        }
        return heaviestItem;
    }
}
