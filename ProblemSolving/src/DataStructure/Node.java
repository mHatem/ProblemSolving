/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author MHatem
 * 
 * Node class is  the basic start to build each of LinkedList , queue and stack :)
 */
public class Node {
    Object data = null ;
    Node next ;
    
    public Node(Object value){
        data = value;
        next= null;
    }
}
