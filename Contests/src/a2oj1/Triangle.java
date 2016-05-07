/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2oj1;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author MHatem
 */
public class Triangle {

    /**
     *
     * Input The first line of the input contains four space-separated positive
     * integer numbers not exceeding 100 — lengthes of the sticks.
     *
     * Output Output TRIANGLE if it is possible to construct a non-degenerate
     * triangle. Output SEGMENT if the first case cannot take place and it is
     * possible to construct a degenerate triangle. Output IMPOSSIBLE if it is
     * impossible to construct any triangle. Remember that you are to use three
     * sticks. It is not allowed to break the sticks or use their partial
     * length.
     */
    public static void main(String[] args) {
        HashSet<String> check = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int t1 = scan.nextInt();
        int t2 = scan.nextInt();
        int t3 = scan.nextInt();
        int t4 = scan.nextInt();

        check.add(isTringale(t1, t2, t3));
        check.add(isTringale(t1, t2, t4));
        check.add(isTringale(t1, t3, t4));
        check.add(isTringale(t2, t3, t4));

        if (check.contains("TRIANGLE")) {
            System.out.println("TRIANGLE");
        } else if (check.contains("SEGMENT")) {
            System.out.println("SEGMENT");
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

    public static String isTringale(int t1, int t2, int t3) {
        if ((t1 + t2 > t3) && (t1 + t3 > t2) && (t3 + t2 > t1)) {
            return "TRIANGLE";
        } else if ((t1 + t2 == t3) || (t1 + t3 == t2) || (t3 + t2 == t1)) {
            return "SEGMENT";
        } else {
            return "IMPOSSIBLE";
        }
    }

}
