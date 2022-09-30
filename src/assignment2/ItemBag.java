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
    public int getNumOfItems() {return this.itemBag.size();}

    public double getCurrentWeight() {
        //find the weight of each item and sum them up
        if (!this.itemBag.isEmpty()) {
            for (Item currentItem : itemBag) {
                currentBagWeight = (currentBagWeight + currentItem.getItemWeight()%2f);
            }
        }
        return this.currentBagWeight;
    }

    public double getMaxWeight() {return this.maxBagWeight;}

    /*7.1 - Adding items to the bag:
    The collection of items can accept repeated items and the items are stored in a specific
    sequence. When adding an item to the bag, the item must be placed in the index where its
    weight is higher than the items after them and lighter than those before (i.e., sorted by
    weight).
    For example:
    [ (P1, 20, 4.5), (P2, 20, 4.5), (P3, 20, 2.2)]
    // after adding (PX, 20, 5.3) - placed at index 0
    [ (PX, 20, 5.3), (P1, 20, 4.5), (P2, 20, 4.5), (P3, 20, 2.2)]
    // after adding (PY, 40, 4.5) - placed at index 1
    [ (PX, 20, 5.3), (PY, 40, 4.5), (P1, 20, 4.5), (P2, 20, 4.5),
    (P3, 20, 2.2)]*/
    public int addItem(Item newItem) {
        for (int i = 0; i < this.itemBag.size(); i++) {
            Item currentItem = itemBag.get(i);
            //Item heaviestItem = itemBag.get(0);
            if (currentItem.getItemWeight() > newItem.getItemWeight()) {
                //heaviestItem = currentItem;
                itemBag.add(i + 1, newItem);
            } else if (currentItem.getItemWeight() < newItem.getItemWeight()) {
                itemBag.add(i - 1, newItem);
            }
        }
        int index = itemBag.indexOf(newItem);
        return index;
    }

    /*7.2 - Removing items:
    The only way to retrieve a reference to an item in the bag is to remove it. Items are removed
    based on a specified index. When removing an item, the bag should automatically
    reorganise itself so that order is preserved and no “empty” slots are left.

    The bag should then return a reference to the removed item. In case the specified index is
    out of bounds, the method should return null.*/
    public String removeItemAt(int index) {
        //remove an item based on specified index
        //automatically reorganise the items in the bag
        String removedItem = "";
        for (int i = 0; i < this.itemBag.size(); i++) {
            Item currentItem = itemBag.get(i);
            Item heaviestItem = itemBag.get(0);
            if (index == i) {
                itemBag.remove(i);
                removedItem = currentItem.toString();
            } else {
                removedItem = null;
            }
            if (currentItem.getItemWeight() > heaviestItem.getItemWeight()) {
                heaviestItem = currentItem;
            }
        }
        return removedItem;
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
