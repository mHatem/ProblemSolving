/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author MHatem
 */
public class linkedList {

    private Node head;     //head of list

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " ->  ");
            tmp = tmp.next;
        }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void sortedInsert(Node new_node) {
        if (head == null || new_node.data <= head.data) {
            new_node.next = head;
            head = new_node;
        } else {
            Node current = head;

            while (current.next != null && current.next.data < new_node.data) {
                current = current.next;
            }

            new_node.next = current;
            current.next = new_node;
        }
    }

    public Node reverse(Node h) {
        if (h.next == null || h == null) {
            return h;
        }

        Node nextNode = h.next;
        h.next = null;

        Node tmp = reverse(nextNode);
        nextNode.next = h;
        return tmp;
    }

    public Node reverse2(Node h,int k) {
        
       Node current = h;
       Node next = null;
       Node prev = null;
       
       int count = 0;
      
       while (count < k  && current != null) 
       {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
       }
       
       if(next != null)
           h.next = reverse2(next, k);
      
       return prev;
 
   }
}
