/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import BST.BST;
import Hash.Hash;

/**
 *
 * @author Mhatem
 */
public class DataStructures {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        BST bst = new BST(10);
//        bst.addNode(5);
//        bst.addNode(1);
//        bst.addNode(2);
//        bst.display();
//        
//        bst.deleteNode(10);
//        System.out.println(bst.root.val);
//        bst.display();
//         bst.addNode(3);
        
       Hash<Integer,Integer> test = new Hash(10);
       test.put(4, 400);
       test.put(4, 440);
       
       System.out.println(test.get(4));
    }
    
}
