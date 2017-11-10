package DataStructure;

import java.util.NoSuchElementException;

public class Queue {
    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; // remove from the head
    private Node tail; // add things here

    public boolean isEmpty() {
        return head == null;
    }
    public int peek() {
        return head.data;
    }
    public void add (int data)
    {
        Node node = new Node(data); // tail = tail.next(x)! tail can be null
        if (tail != null)
        {
            tail.next = node;
        }
        tail = node;
        if (head == null)
        {
            head = node;
        }
    }
    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        int data = head.data;
        head = head.next;
        if (head== null)
            tail = head;
        return data;
    }
}
