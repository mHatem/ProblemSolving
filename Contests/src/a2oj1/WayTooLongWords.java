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
public class WayTooLongWords {

    /*
     Input
     The first line contains an integer n (1 ≤ n ≤ 100). Each of the following n lines contains one word. All the words consist of lowercase Latin letters and possess the lengths of from 1 to 100 characters.

     Output
     Print n lines. The i-th line should contain the result of replacing of the i-th word from the input data.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =  scan.nextInt();
        ArrayList<String> strList = new ArrayList<>();
        int i ;
        for( i = 0 ; i < n ; i ++){
            strList.add(scan.next());
        }
        for(String str : strList){
            if(str.length() > 10){
                str =   str.charAt(0)+String.valueOf(str.length()-2) + str.charAt(str.length()-1);
            }
            System.out.println(str);
        }
    }

}
