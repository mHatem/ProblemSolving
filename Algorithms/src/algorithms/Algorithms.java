/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import DP.LongestSequences;

/**
 *
 * @author MHatem
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] arr = {10,22,9,33,21,50,41,60,80};
        LongestSequences lcs = new  LongestSequences();
        System.out.println(lcs.lis(arr));
    }
    
}
