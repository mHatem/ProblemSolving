/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Mhatem
 * @param <K> key parameter type
 * @param <V> Value parameter type
 */
public class Hash<K,V> {
    private final ArrayList<LinkedListNode<K,V>> items;
    
    public Hash(int capacity){
        items = new ArrayList<>();
        items.ensureCapacity(capacity);
        for(int i = 0 ; i < capacity ; i ++){
            items.add(null);
        }
    }
    /**
     * 
     * @param key
     * @param value 
     */
    public void put(K key, V value){
        int index = hashCodeOfKey(key);
        LinkedListNode<K,V> node = items.get(index);
        if(node == null){
            node = new LinkedListNode(key,value);
            
        }else{
            
            if(node.key == key){
                node.value = value;
            }
            else{
             LinkedListNode<K,V> node2 = new LinkedListNode(key, value);
             LinkedListNode<K,V> itr = node;
             while(itr.next != null){
                 itr = itr.next;
             }
             node2.prev = itr;
             itr.next= node2;
            }
            
        }
        items.set(index, node);
    }
    /**
     * 
     * @param key
     * @return 
     */
    public V get(K key){
        LinkedListNode<K,V> node = items.get(hashCodeOfKey(key));
        if(node.key == key){
            return node.value;
        }
        while(node != null){
            if(node.key == key)
                return node.value;
            node = node.next;
        }
        return null;
    }
    
    int hashCodeOfKey(K key){
        return key.toString().length() % items.size();
    }
    
    
   private static class LinkedListNode<K,V> {

    public LinkedListNode<K,V> next;
    public LinkedListNode<K,V> prev;
    public K key;
    public V value;
    
    public LinkedListNode(K k, V v){
        this.key = k;
        this.value = v;
    }
}
}
