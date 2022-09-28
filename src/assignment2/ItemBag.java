package assignment2;

/*Task 7: Item Storage
Your program should have an Item Bag to store items. An item bag has a maximum weight
defined when creating the bag. The bag also stores a collection of items that begins empty
when creating the bag. The maximum weight cannot change once the bag is created. You
don’t need to write code to check if two bags are equal.
The bag should provide: the current number of items stored, the current weight of the bag,
and its maximum weight. Other operations are defined below.
7.1 - Adding items to the bag:
The collection of items can accept repeated items and the items are stored in a specific
sequence. When adding an item to the bag, the item must be placed in the index where its
weight is higher than the items after them and lighter than those before (i.e., sorted by
weight).
Note: You don’t need to use Arrays.sort or Collections.sort for solving this task. In fact, using
these sorting libraries can make your code inefficient.
For example:
[ (P1, 20, 4.5), (P2, 20, 4.5), (P3, 20, 2.2)]
// after adding (PX, 20, 5.3) - placed at index 0
[ (PX, 20, 5.3), (P1, 20, 4.5), (P2, 20, 4.5), (P3, 20, 2.2)]
// after adding (PY, 40, 4.5) - placed at index 1
[ (PX, 20, 5.3), (PY, 40, 4.5), (P1, 20, 4.5), (P2, 20, 4.5),
(P3, 20, 2.2)]
7.2 - Removing items:
The only way to retrieve a reference to an item in the bag is to remove it. Items are removed
based on a specified index. When removing an item, the bag should automatically
reorganise itself so that order is preserved and no “empty” slots are left.
The bag should then return a reference to the removed item. In case the specified index is
out of bounds, the method should return null.
7.3 - Peeking at items:
A user can peek at the item in a specific position in the bag. The bag should not provide a
reference to the actual item. Instead, the bag returns a string representation of the item
according to what has been specified in Task X.
7.4 - Popping items:
A user can retrieve the heaviest item in the bag. This means that the bag should remove
and return a reference to its first item. Typically, this operation is named ‘pop’. If the bag is
empty, popping should return null.*/

public class ItemBag {
    /*An item bag has a maximum weight
    defined when creating the bag. The bag also stores a collection of items that begins empty
    when creating the bag. The maximum weight cannot change once the bag is created. You
    don’t need to write code to check if two bags are equal.*/
    private double maxBagWeight;
}
