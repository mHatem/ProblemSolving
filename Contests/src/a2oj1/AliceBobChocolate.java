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
public class AliceBobChocolate {

    /*
     * Input The first line contains one integer n (1 ≤ n ≤ 105) — the amount of
     * bars on the table. The second line contains a sequence t1, t2, ..., tn (1
     * ≤ ti ≤ 1000), where ti is the time (in seconds) needed to consume the
     * i-th bar (in the order from left to right).
     *
     * Output Print two numbers a and b, where a is the amount of bars consumed
     * by Alice, and b is the amount of bars consumed by Bob.
     * 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        ArrayList<Integer> sequences = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            sequences.add(scan.nextInt());
        }

        int bob = 0, alice = 0;
        int j = -1, a = 0, b = 0;
        int k = amount;

        while (Math.abs(j-k) != 1) {
             if (alice > bob ) { 
                k--;
                b++;
                bob += sequences.get(k);
            } else {
                j++;
                alice += sequences.get(j);
                a++;
            }
        }
        
        System.out.println(a +" " + b);

    }

}
