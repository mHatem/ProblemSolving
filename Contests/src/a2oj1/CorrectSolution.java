/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2oj1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MHatem
 */
public class CorrectSolution {

    /*—Shuffle the digits in this number in order to obtain the smallest possible number without leading zeroes.
     —No problem! — said Bob and immediately gave her an answer.
     Alice said a random number, so she doesn't know whether Bob's answer is correct. Help her to find this out, because impatient brother is waiting for the verdict.

     Input
     The first line contains one integer n (0 ≤ n ≤ 109) without leading zeroes. The second lines contains one integer m (0 ≤ m ≤ 109) — Bob's answer, possibly with leading zeroes.

     Output
     Print OK if Bob's answer is correct and WRONG_ANSWER otherwise.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String q= scan.next();
        String a= scan.next();
        
        char[] chars = q.toCharArray();
        Arrays.sort(chars);
        int i = 0;
        while(i < chars.length  && chars[i] == '0'){
            i ++;
        }
        if(i < chars.length  && i != 0){
            chars[0] = chars[i];
            chars[i] = '0' ; 
        }
        
        if(String.valueOf(a).equals(String.valueOf(chars)))
            System.out.println("OK");
        else
            System.out.println("WRONG_ANSWER");
    }

}
