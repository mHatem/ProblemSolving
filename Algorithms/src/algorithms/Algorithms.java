/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import DP.EditDistance;
import LinkedList.linkedList;


/**
 *
 * @author MHatem
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] arr = {1,6,5,11};
        EditDistance ed = new EditDistance();
        
        linkedList llist = new linkedList();
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Given Linked List");
        llist.printList();
         
        llist.setHead(llist.reverse2(llist.getHead(),3));
 
        System.out.println("Reversed list");
        llist.printList();
        
    
    }
    
     public static int Solution (int[] arr){
       int ind = arr.length - 1;
         int max = arr[ind];
         int count [] = new int[max + 31];
         
         count[arr.length-1] = 1;
         for(int i = max; i >= 0 ; i--){
             count[i] = count[i+1];
             if(i == max){
                 if(ind <= 0)
                     max = -1;
                 else
                     max = arr[ind-1];
		ind--;
                count[i] += 2;
                count[i] = Math.min(count[i], 7 + count[i + 7]);
                count[i] = Math.min(count[i], 25 + count[i + 30]);
             }
         }
         return count[0];
     }
    
}
