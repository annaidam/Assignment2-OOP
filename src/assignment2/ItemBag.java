package assignment2;

import java.lang.reflect.Array;
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
        int sizeOfBag = 0;
        if (this.itemBag.isEmpty()) {
            return sizeOfBag;
        } else {
            return sizeOfBag = this.itemBag.size();
        }
    }

    public double getCurrentWeight() {
        //find the weight of each item and sum them up
        if (!this.itemBag.isEmpty()) {
            for (Item currentItem : itemBag) {
                currentBagWeight = (currentBagWeight + currentItem.getItemWeight());
            }
        }
        return this.currentBagWeight;
    }

    public double getMaxWeight() {return this.maxBagWeight;}

    public void sortTheBag() {
        if (!this.itemBag.isEmpty()) {
            int length = itemBag.size();
            if (length > 1) {
                for (int i = 0; i < length; i++) {
                    Item currentItem1 = this.itemBag.get(i);
                    for (int j = i + 1; j < length; j++) {
                        Item currentItem2 = this.itemBag.get(j);
                        if (currentItem1.getItemWeight() < currentItem2.getItemWeight()) {
                            Item x = currentItem1;
                            currentItem1 = currentItem2;
                            currentItem2 = x;
                            //itemBag.add(itemBag.indexOf(currentItem1), currentItem2);
                        }
                    }
                }
            }
        }
    }

/*
    public void sortTheBag() {
        for (int i = 0; i < this.itemBag.size(); i++) {
            Item currentItem1 = itemBag.get(i);
            for (int j = i + 1; j < this.itemBag.size(); j++) {
                Item currentItem2 = itemBag.get(j);
                Item newItem;
                Item oldItem;
                if (currentItem1.getItemWeight() < currentItem2.getItemWeight()) {
                    x = this.oldItem(i);
                    this.oldItem(i) = this.newItem(j);
                    this.oldItem(j) = x;
                }
            }
        }
    }


 */

    /*7.1 - Adding items to the bag:
    The collection of items can accept repeated items and the items are stored in a specific
    sequence. When adding an item to the bag, the item must be placed in the index where its
    weight is higher than the items after them and lighter than those before (i.e., sorted by
    weight).*/
/*
 Pseudocode :
PROCEDURE LINEAR_SEARCH (LIST, VALUE)
  FOR EACH ITEM IN THE LIST
     IF SAME ITEM == VALUE
          RETURN THE ITEM’S LOCATION
     END IF
  END FOR
END PROCEDURE*/

    public int addItem(Item newItem) {
        if (itemBag.isEmpty()) {
            itemBag.add(0, newItem);
            return 0;
        } else {
            for (int i = 0; i < itemBag.size(); i++) {
                Item currentItem = itemBag.get(i);
                if (currentItem.getItemWeight() < newItem.getItemWeight()) {
                    itemBag.add(itemBag.indexOf(currentItem), newItem);
                }
            }
        }
        int indexOfNewItem = itemBag.indexOf(newItem);
        return indexOfNewItem;
    }

    /*public int addItem(Item newItem) {
        sortTheBag();
        int indexOfNewItem;
        int length = itemBag.size();
        for (int i = 0; i < length; i++) {
            Item oldItem = itemBag.get(i);
            for (int j = i + 1; j < length; j++) {
                newItem = itemBag.get(j);
                //itemBag.add(j, newItem);
                if (oldItem.getItemWeight() < newItem.getItemWeight()) {
                    oldItem = itemBag.get(i);
                    itemBag.add(j, oldItem);
                    itemBag.add(i, newItem);
                    indexOfNewItem = itemBag.indexOf(newItem);
                }
            }
        }
        sortTheBag();
        return indexOfNewItem;
    }*/

    /*7.2 - Removing items:
    The only way to retrieve a reference to an item in the bag is to remove it. Items are removed
    based on a specified index. When removing an item, the bag should automatically
    reorganise itself so that order is preserved and no “empty” slots are left.

    The bag should then return a reference to the removed item. In case the specified index is
    out of bounds, the method should return null.*/
    public String removeItemAt(int index) {
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
        sortTheBag();
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
