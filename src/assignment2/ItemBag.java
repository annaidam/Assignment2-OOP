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
                currentBagWeight = (currentBagWeight + currentItem.getItemWeight());
            }
        }
        return this.currentBagWeight;
    }

    public double getMaxWeight() {return this.maxBagWeight;}

    /*7.1 - Adding items to the bag:
    The collection of items can accept repeated items and the items are stored in a specific
    sequence. When adding an item to the bag, the item must be placed in the index where its
    weight is higher than the items after them and lighter than those before (i.e., sorted by
    weight).*/

    /*
       public int addItem(Item newItem) {
           //adding a new item
           itemBag.add(newItem);
           //if bag is empty, we place the item in the first slot
           if (this.itemBag.isEmpty()) {
               itemBag.set(0, newItem);
           //if after adding the item, the bag's weight exceeds the max bag weight,
           //we remove the added item and return its index BUT because in the example
           //the removed item is equal to other two items added, this will get the index
           //of the equal item, not the item we removed
           } else if (this.currentBagWeight >= this.maxBagWeight) {
               itemBag.remove(newItem);
               return itemBag.indexOf(newItem);
           //after adding the item, we calculate its right place
           } else {
               int length = itemBag.size();
               for (int i = 0; i < length; i++) {
                   for (int j = length - 1; j > i; j--) {
                       if (itemBag.get(i).getItemWeight() < itemBag.get(j).getItemWeight()) {
                           Item temporary = itemBag.get(i);
                           itemBag.set(i, itemBag.get(j));
                           itemBag.set(j, temporary);
                       }
                   }
               }
           }

           return itemBag.indexOf(newItem);
       }
           /*

     We start with an ArrayList of length 0, therein, we assign the item to the first, that is, the only available position.
     That’s the base case.

       For the general case: we may consider the traditional linear search - we iterate over the List.
       We check whether the value of the current item,
       i. e., the weight is greater than the value (weight of the item) at the i-th index,
       if so, we insert the current item at that certain index,
       using the in-built behaviours of the ArrayList Class - “add(index, item)”,
       therefore enlarging the List by +1.
       That’s the whole idea of the algorithm of time complexity O(n).

       2 extra points to consider:
   - ensure that the maximum weight isn’t exceeded;
   - ensure that the item will increase the weight stored in the item bag.
        */
        public int addItem(Item newItem) {
            if (this.itemBag.isEmpty()) {
                itemBag.add(newItem);

            int length = itemBag.size();
            if(this.currentBagWeight < this.maxBagWeight){
            for (int i = 0; i < length; i++)
                if(newItem.getItemWeight() > itemBag.get(i).getItemWeight()){
                //if(current item weight > item weight at index i)
                    //add(index i, current item)

                itemBag.add(itemBag.indexOf(itemBag.get(i)), newItem);
                length = length + 1;
                this.currentBagWeight = this.currentBagWeight + newItem.getItemWeight();

        }
        }
            }
            return itemBag.indexOf(newItem);
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
