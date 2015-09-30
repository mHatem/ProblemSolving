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
        
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        
        ArrayList<Interval> AInt = new ArrayList<>();
        AInt.add(new Interval(1, 2));
        AInt.add(new Interval(3, 6));
        
      
        ArraysProblems arr = new ArraysProblems();
        //System.out.println(arr.insertInterval(AInt,new Interval(4, 9))); 
        //System.out.println(A); 
       AInt =  arr.insertInterval(AInt,new Interval(8, 10));
       for(Interval i : AInt){
           System.out.println("[ " + i.start +" , "+ i.end +" ]");
       }
    }  
}
