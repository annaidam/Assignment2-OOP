package assignment2;

import java.util.ArrayList;

public class ItemBag {
    /*An item bag has a maximum weight defined when creating the bag.
    The bag also stores a collection of items that begins empty when creating the bag.
    The maximum weight cannot change once the bag is created. You don’t need to write code to check if two bags are equal.*/
    private double maxBagWeight;
    private double currentBagWeight = 0;
    ArrayList<Item> itemBag = new ArrayList<>();

    public ItemBag(double maxBagWeight) {
        this.maxBagWeight = maxBagWeight;
    }

    /*The bag should provide: the current number of items stored, the current weight of the bag,
    and its maximum weight. Other operations are defined below.*/
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
        if (!this.itemBag.isEmpty()) {
            for (Item currentItem : itemBag) {
                currentBagWeight = (currentBagWeight + currentItem.getWeight());
            }
        }
        return this.currentBagWeight;
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
        String removing = "";
        for (int i = 0; i < this.itemBag.size(); i++) {
            if (index == i) {
                Item removedItem = itemBag.get(i);
                removing = removedItem.toString();
                itemBag.remove(i);
            } else if (index < 0 | index > (this.itemBag.size() - 1)) {
                removing = null;
            }
        }
        return removing;
    }

    /*7.3 - Peeking at items:
    A user can peek at the item in a specific position in the bag. The bag should not provide a
    reference to the actual item. Instead, the bag returns a string representation of the item
    according to what has been specified in Task X.*/
    public String peekItemAt(int index) {
        String peeking = "";
        for (int i = 0; i < this.itemBag.size(); i++) {
            Item currentItem = itemBag.get(i);
            if (index == i) {
                peeking = currentItem.toString();
            }
        }
        return peeking;
    }

    /*7.4 - Popping items:
    A user can retrieve the heaviest item in the bag. This means that the bag should remove
    and return a reference to its first item. Typically, this operation is named ‘pop’. If the bag is
    empty, popping should return null.*/
    public String popItem() {
        //find the heaviest item in the bag ie. the first ite
        //if bag is empty popping returns to null
        String message = "";
        if (!itemBag.isEmpty()) {
            Item heaviestItem = itemBag.get(0);
            message = heaviestItem.toString();
            itemBag.remove(0);
        } else {
            return null;
        }
        return message;
    }
}
