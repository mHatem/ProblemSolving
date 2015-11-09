/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author MHatem
 * Stack data structure written by JAVA
 */
public class Stack {

    private Node top;
    private int size = 0;

    public Object pop() {
       Object tmp;
        if (top == null) {
            tmp =  null;
        } else {
            tmp =  top.data;
            top = top.next;
        }
        size --;
        return tmp;
    }
    public void push(Object value){
        Node x = new Node (value);
        x.next = top;
        top = x;
        size ++;
    }
    
    public Object top(){
        return top.data;
    }
    
    public int size(){
        return size;
    }
}
