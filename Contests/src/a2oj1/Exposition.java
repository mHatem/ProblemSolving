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
public class Exposition {

    /*
     The library has n volumes of books by Berlbury, arranged in chronological order of their appearance. The height of each book in millimeters is know, it is hi. As Berlbury is highly respected in the city, the organizers want to include into the exposition as many books as possible, and to find out what periods of his creative work they will manage to cover. You are asked to help the organizers cope with this hard task.
     Input
     The first line of the input data contains two integer numbers separated by a space n (1 ≤ n ≤ 105) and k (0 ≤ k ≤ 106) — the amount of books by Berlbury in the library, and the maximum allowed height difference between the lowest and the highest books. The second line contains n integer numbers separated by a space. Each number hi (1 ≤ hi ≤ 106) is the height of the i-th book in millimeters.
     Output
     In the first line of the output data print two numbers a and b (separate them by a space), where a is the maximum amount of books the organizers can include into the exposition, and b — the amount of the time periods, during which Berlbury published a books, and the height difference between the lowest and the highest among these books is not more than k milllimeters.
     In each of the following b lines print two integer numbers separated by a space — indexes of the first and the last volumes from each of the required time periods of Berlbury's creative work.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> hights =  new ArrayList<>();
        int n = scan.nextInt(); // amount of books
        int k = scan.nextInt(); // the maximum allowed height difference between the lowest and the highest books
        
        for(int i = 0 ; i < n ;i ++){
            hights.add(scan.nextInt());
        }
        
        
        
    }

}
