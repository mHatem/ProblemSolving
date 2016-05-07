/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2oj1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MHatem
 */
public class ProgressBar {

    /*
     Input
     We are given 3 space-separated integers n, k, t (1 ≤ n, k ≤ 100, 0 ≤ t ≤ 100).

     Output
     Print n numbers. The i-th of them should be equal to ai.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int t = scan.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        int  i ;
        float mode = (t/100.0f)*n;
        for(i = 0 ; i < (int)mode ; i++){
            numbers.add(k);
        }
        if((mode - (int)mode)* k >= 1){
            numbers.add((int)((mode - (int)mode)* k));
            i++;
        }
        for( ; i < n ; i++)
            numbers.add(0);
        
        for(i = 0 ; i < numbers.size() ; i++)
            System.out.print(numbers.get(i) + " ");
    }

}
