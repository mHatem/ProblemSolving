/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataStructure.BSTree;
import DataStructure.UndirectedGraphNode;
import ProblemSolving2.Graphs;
import ProblemSolving2.backTrackingDynamic;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import problemsolving.Others;



/**
 *
 * @author MHatem
 */
public class ProblemSolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

      ArrayList<Integer> a =  new ArrayList<>();
      a.add(1);
      a.add(1);
      a.add(2);
      Others o = new Others();
      System.out.println(o.removeDuplicates(a));
        
        
    }
}
