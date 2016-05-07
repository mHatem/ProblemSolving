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
public class PresidentOffice {

    /*
     Input
     The first line contains two separated by a space integer numbers n, m (1 ≤ n, m ≤ 100) — the length and the width of the office-room, and c character — the President's desk colour. The following n lines contain m characters each — the office-room description. It is guaranteed that the colour of each desk is unique, and each desk represents a continuous subrectangle of the given matrix. All colours are marked by uppercase Latin letters.

     Output
     Print the only number — the amount of President's deputies.
     */
    public static void main(String[] args) {
        HashSet<Character> deputies = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int n, m, i, j;
        char pColor;
        n = scan.nextInt();
        m = scan.nextInt();
        pColor = scan.next().charAt(0);
        String[] room = new String[n];
        for (i = 0; i < n; i++) {
            room[i] = scan.next();
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (room[i].charAt(j) == pColor) {
                    if (j + 1 < m && room[i].charAt(j + 1) != '.' && room[i].charAt(j + 1) != pColor) {
                        deputies.add(room[i].charAt(j + 1));
                    }
                    if (j - 1 > -1 && room[i].charAt(j - 1) != '.' && room[i].charAt(j - 1) != pColor) {
                        deputies.add(room[i].charAt(j - 1));
                    }
                    if (i + 1 < n && room[i + 1].charAt(j) != '.' && room[i + 1].charAt(j) != pColor) {
                        deputies.add(room[i + 1].charAt(j));
                    }
                    if (i - 1 > -1 && room[i - 1].charAt(j) != '.' && room[i - 1].charAt(j) != pColor) {
                        deputies.add(room[i - 1].charAt(j));
                    }
                }
            }
        }

        System.out.println(deputies.size());
    }
}
