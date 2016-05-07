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
public class Exam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        if (n == 1) {
            System.out.println("1");
            numbers.add(1);
        } else if (n == 2) {
            System.out.println("1");
            numbers.add(1);
        } else if (n == 3) {
            System.out.println("2");
            numbers.add(1);
            numbers.add(3);
        } else if (n == 4) {
            System.out.println("4");
            numbers.add(3);
            numbers.add(1);
            numbers.add(4);
            numbers.add(2);
        } else {
            for (int i = 1; i <= (n - 1)/ 2; i++) {
                numbers.add(i);
                if(Math.abs(i - (n-i))!= 1)
                 numbers.add(n - i);
            }
            numbers.add(n);
            if (n % 2 == 0) {
                numbers.add(n / 2);
            } else {
                numbers.add((n-1)/2 + 1);               
            }
        System.out.println(n);
        }
        
        for(int j= 0 ; j < numbers.size() ; j++){
            System.out.print(numbers.get(j) + " ");
        }
    }

}
