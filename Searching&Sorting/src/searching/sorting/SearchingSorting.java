/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching.sorting;

import Sorting.Sort;
import java.util.Arrays;

/**
 *
 * @author Mhatem
 */
public class SearchingSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] arr = {3,4,5,1,0,3};
       Sort s = new Sort();
       s.quickSort(arr);
       System.out.print(Arrays.toString(arr));
    }
    
}
