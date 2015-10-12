/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author MHatem
 */
public class ProblemSolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Test stack
//        Stack s = new Stack();
//        s.push(3);
//        s.push(4);
//        s.push(5);
//        s.push(6);
//        
//        for(int i = 0 ; i < s.size(); i++)
//            System.out.println(s.pop());
//        
//        // Test Queue 
//        Queue q = new Queue();
//        q.enqueue(3);
//        q.enqueue(4);
//        q.enqueue(5);
//        q.enqueue(6);
//        
//        for(int i = 0 ; i < s.size(); i++)
//            System.out.println(q.dequeue());
        
        ArraysProblems a  =  new  ArraysProblems();
         ArrayList<ArrayList<Integer>> res = a.prettyPrint(9);
         for(int i=0 ;i<res.size(); i++){
             System.out.println(res.get(i));
         }
    }  
}
