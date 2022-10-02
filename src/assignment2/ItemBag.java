package assignment2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ItemBag {
    private double maxBagWeight;
    private double currentBagWeight;
    ArrayList<Item> itemBag = new ArrayList<>();

    public ItemBag(double maxBagWeight) {
        this.maxBagWeight = maxBagWeight;
    }

    public int getNumOfItems() {
        if (this.itemBag.isEmpty()) {
            return 0;
        } else {
            int sizeOfBag = this.itemBag.size();
            return sizeOfBag;
        }
    }

    public double getCurrentWeight() {
        //find the weight of each item and sum them up
        currentBagWeight = 0;
        if (!this.itemBag.isEmpty()) {
            for (Item currentItem : itemBag) {
                currentBagWeight += currentItem.getWeight();
            }
        }
        BigDecimal bd = new BigDecimal(currentBagWeight).setScale(2, RoundingMode.HALF_UP);
        double result = bd.doubleValue();
        return result;
    }

    public double getMaxWeight() {return this.maxBagWeight;}

    public int addItem(Item newItem) {
        boolean itemAdded = false;
        if (currentBagWeight + newItem.getWeight() > maxBagWeight) {
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
        //remove an item based on specified index
        //automatically reorganise the items in the bag
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
        //find the heaviest item in the bag ie. the first ite
        //if bag is empty popping returns to null
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
