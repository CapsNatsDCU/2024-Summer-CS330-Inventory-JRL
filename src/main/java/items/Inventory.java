package items;

import containers.LinkedList;
import containers.LinkedList.Node;


/**
 * An Inventory is composed of n slots. Each slot may store only
 * one type of item--specified by *slots*.
 * <p>
 * Once all slots are filled, no additional Item types may be
 * stored. Individual slots may contain any number of the same
 * Item--if the Item is stackable.
 */

public class Inventory
{
    /**
     * This is the Default Inventory size.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * This is utility function that takes two ItemStacks and adds the
     * number of items in the right-hand side stack to the left-hand side stack.
     *
     * @param lhs stack whose size will be increased
     * @param rhs stack whose size we need to examine
     */
    public static void mergeStacks(ItemStack lhs, ItemStack rhs)/////////////////////////// DONE
    {
        // lhs needs to have items added to it.
        // rhs's size is needed
        // lhs.????(rhs.????)
        lhs.addItems(rhs.size());
    }

    /**
     * Individual item slots--each ItemStack occupies one slot.
     */
    private LinkedList<ItemStack> slots;

    /**
     * Total number of distinct Item types that can be stored.
     */
    private int capacity;

    /**
     * Default to an inventory with 10 slots.
     */
    public Inventory()
    {
        this(DEFAULT_SIZE);
    }

    /**
     * Create an inventory with n slots.
     *
     * @param desiredCapacity size of the new Inventory
     */
    public Inventory(int desiredCapacity)
    {
        this.slots    = new LinkedList<ItemStack>();
        this.capacity = desiredCapacity;
    }

    /**
     * Determine the number of slots currently in use.
     */
    public int utilizedSlots()
    {
        return this.slots.currentSize;
    }

    /**
     * Determine the number of empty (unused) slots.
     */
    public int emptySlots()
    {
        return this.totalSlots() - this.utilizedSlots();
    }

    /**
     * Retrieve the capacity (number of distinct types of items) that this
     * inventory can store.
     */
    public int totalSlots()
    {
        return this.capacity;
    }

    /**
     * Determine if the inventory is considered full.
     *
     * @return true if the current size is equal to capacity
     */
    public boolean isFull()//////////////////////////////////////////////////////////////// DONE
    {
        return this.slots.currentSize == capacity;
    }

    /**
     * Determine if the inventory is empty.
     *
     * @return true if current size is zero
     */
    public boolean isEmpty()
    {
        return this.slots.currentSize == 0;
    }

    /**
     * Search through all slots (Nodes in the LinkedList) and look for a
     * matching ItemStack.
     *
     * @param key stack for which the search is being conducted
     *
     * @return matching stack if one was found and `null` otherwise
     */
    public ItemStack findMatchingItemStack(ItemStack key) /////////////////////////////////// DONE
    {
        // Add the necessary sequential search loop
        LinkedList<ItemStack> it = this.slots;
        while (it.currentSize > this.slots.currentSize){
            if (it.head.data.equals(key)){
                //System.out.println("match");  
                return key;
            } else {
                removeHead(it);
            }
        }
        //System.out.println("no match");
        return null;
    }

    /**
     * This is the standard Linked List append operation from Review 01
     *
     * @param toAdd data that we want to store in a Node and add to the list
     */
    public void addItemStackNoCheck(ItemStack toAdd)////////////////////////////////////////// DONE
    {
        // Use the appendNode/add logic from Review 1 as your starting point
        // Once we reach this function... we know that `toAdd` must be stored

        addLast(toAdd);
    }

    /**
     * Add one or more items to the inventory list.
     *
     * @param stack new stack of items to add
     *
     * @return true if *stack* was added and false otherwise
     */
    public boolean addItems(ItemStack stack)
    {
        ItemStack match = this.findMatchingItemStack(stack);

        if (match != null) {
            // If the Item is stackable, add it to the ItemStack
            if (match.permitsStacking()) {
                mergeStacks(match, stack);

                return true;
            }
        }

        if (this.slots.currentSize < capacity) {
            this.addItemStackNoCheck(stack);
            return true;
        }

        return false;
    }

    /**
     * *Print* a Summary of the Inventory and all Items contained within.
     */
    @Override
    public String toString()
    {
        String summaryLine = String.format(
            " -Used %d of %d slots%n", this.slots.currentSize, this.capacity
        );

        StringBuilder strBld = new StringBuilder();
        strBld.append(summaryLine);

        LinkedList.Node<ItemStack> it = this.slots.head;

        while (it != null) {
            String itemLine = String.format("  %s%n", it.data);
            strBld.append(itemLine);

            it = it.next;
        }

        return strBld.toString();
    }

    /**
     * this method removes the head
     * 
     * @param it is the liked list to use
     */

     public void removeHead(LinkedList<ItemStack> it) {
        if (it.head == it.tail) {
          it.head = it.tail = null;
        } else {
          it.head = it.head.next;
        }
        it.currentSize--;
    }
      


    /**
    * 
    * @param data the itemstack to add
    */

    public void addLast(ItemStack toAdd) {
        Node<ItemStack> lemon = new Node<ItemStack>(toAdd);
        //System.out.println(lemon.toString());
        if (isEmpty()) {
            slots.head = slots.tail = lemon;
        } else {
            slots.tail.next = lemon;
            slots.tail = lemon;
        }
        //System.out.println(slots.tail.toString());
        slots.currentSize++;
    }      
}


