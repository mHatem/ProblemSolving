/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2oj1;

import java.util.Scanner;

/**
 *
 * @author MHatem
 */
public class SuperAgent {

    /*Pearlo knows that the password consists from distinct digits and is probably symmetric with respect to the central button of the terminal. He has heat sensor which allowed him to detect the digits which the worker pressed. Now he wants to check whether the password entered by the worker is symmetric with respect to the central button of the terminal. This fact can Help Pearlo to reduce the number of different possible password combinations.

     Input
     Input contains the matrix of three rows of three symbols each. Symbol «X» means that the corresponding button was pressed, and «.» means that is was not pressed. The matrix may contain no «X», also it may contain no «.».

     Output
     Print YES if the password is symmetric with respect to the central button of the terminal and NO otherwise.
     */
    public static void main(String[] args) {
        int i;
        Scanner scan = new Scanner(System.in);
        String[] matrix = new String[3];
        for (i = 0; i < 3; i++) {
            matrix[i] = scan.next();
        }

        if (matrix[0].charAt(0) == 'X' && matrix[2].charAt(2) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[0].charAt(1) == 'X' && matrix[2].charAt(1) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[0].charAt(2) == 'X' && matrix[2].charAt(0) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[1].charAt(0) == 'X' && matrix[1].charAt(2) != 'X') {
            System.out.println("NO");
            return;
        }
        else if (matrix[2].charAt(2) == 'X' && matrix[0].charAt(0) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[2].charAt(1) == 'X' && matrix[0].charAt(1) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[2].charAt(0) == 'X' && matrix[0].charAt(2) != 'X') {
            System.out.println("NO");
            return;
        } else if (matrix[1].charAt(2) == 'X' && matrix[1].charAt(0) != 'X') {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

}
