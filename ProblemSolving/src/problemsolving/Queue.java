/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

/**
 *
 * @author MHatem
 */
public class Queue {
    private Node first, last;
    private int size = 0;
    
    public Object dequeue(){
        Object tmp;
        if(first == null){
            tmp = null;
        }
        else{
            tmp = first.data;
            first = first.next;
        }
        return tmp;
    }
    
    public void enqueue(Object value){
        Node x = new Node(value);
        if(first == null){
            first = x;
            last = x;
        }
        else{
            last.next = x;
            last = x;
        }
        size++;
    }
    
    public int size(){
        return size;
    }
}
