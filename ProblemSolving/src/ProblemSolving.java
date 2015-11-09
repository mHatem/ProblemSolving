/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataStructure.BSTree;
import ProblemSolving2.backTrackingDynamic;
import java.util.ArrayList;
import java.util.LinkedList;



/**
 *
 * @author MHatem
 */
public class ProblemSolving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(4);
        backTrackingDynamic dp = new backTrackingDynamic();
        System.out.print(dp.canJump(a));
    }
}
