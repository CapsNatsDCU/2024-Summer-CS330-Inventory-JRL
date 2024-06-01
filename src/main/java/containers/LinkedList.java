package containers;

import org.w3c.dom.Node;

import items.Item;
import items.ItemStack;

public class LinkedList<T>
{
    public static class Node<T>
    {
        public T     data;
        public Node  next;

        public Node()
        {
            this.data = null;
            this.next = null;
        }

        public Node(T d)
        {
            this.data = d;
            this.next = null;
        }
    }

    /**
     * this is the method to add a node
     */
    public void addItemStack(ItemStack newData){
        Node<ItemStack> nova = new Node<ItemStack>(newData);
        if (this.currentSize > 0){
            tail.next = nova;
            tail = nova;
        } else {
            head = nova;
        }
        currentSize++;
    }

    /**
     * public void addItemStack(ItemStack newData) {
    Node<ItemStack> newNode = new Node<>(newData);
    if (isEmpty()) {  // Check if the list is empty
        head = tail = newNode;
    } else {
        tail.next = newNode;  // Update next pointer of current tail
        tail = newNode;        // Update tail to point to the new node
    }
    currentSize++;
}

     */

    /**
     * This is a pointer to the head (first)
     * Node
     */
    public Node head;

    /**
     * This is a pointer to the tail (last)
     * Node
     */
    public Node tail;

    /**
     * Current size of the LinkedList--e.g.,
     * current (actual) number of rooms
     */
    public int currentSize;

    public LinkedList()
    {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }
}
