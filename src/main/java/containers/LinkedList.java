package containers;

import org.w3c.dom.Node;

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
    public void add(T newData){
        Node<T> nova = new Node<T>(newData);
        if (this.currentSize > 0){
            tail = nova;
        } else {
            head = nova;
        }
    }

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
