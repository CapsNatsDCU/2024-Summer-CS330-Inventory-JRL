package containers;

import org.w3c.dom.Node;

import items.Item;
import items.ItemStack;

@SuppressWarnings("unused")
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
     * this method removes the head
     * cioped from AI
     */

     public Node removeHead() {
        // Handle the empty list case
        if (head == null) {
          return null;
        }
      
        // Store the current head for return
        Node removedHead = head;
      
        // Update head to point to the next node
        head = head.next;
      
        // Free the memory of the removed node (optional)
        removedHead.next = null;
      
        return removedHead;
      }


    /**
     * 
     * @param data the itemstack to add
     */

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        // If the list is empty, set both head and tail to the new node
        if (currentSize == 0) {
          head = tail = newNode;
        } else {
          // Set the new node's next pointer to the current head
          newNode.next = head;
          // Update the head to point to the new node
          head = newNode;
        }
        currentSize++;
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
