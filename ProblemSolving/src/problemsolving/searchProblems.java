/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.ArrayList;

/**
 *
 * @author MHatem
 */
public class searchProblems {

    public int binarySearch(ArrayList<Integer> arr, int target) {

        int i = arr.size() / 2, start = 0, end = arr.size();
        while (arr.get(i) != target) {
            if (target > arr.get(i)) {
                start = i + 1;
                i = (start + end) /2; 
            }else if (target < arr.get(i)) {
                end = i - 1;
                i = (start + end) /2;
            }
        }
        return i ;
    }
    
    public ArrayList<Integer> searchRange(ArrayList<Integer> a, int b) {

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        boolean flag = false;
        int i = a.size() / 2, start = 0, end = a.size();
        while (b != a.get(i)) {
            if (b > a.get(i)) {
                start = i + 1;
                i = (start + end) /2; 
            }else if (b < a.get(i)) {
                end = i - 1;
                i = (start + end) /2;
            }  
            else{
                while(i >= 0 && a.get(i)== b){
                    i--;
                    flag = true;
                }
            } 
            if(flag)
                break;
          
        }
        i++;
        while(i < a.size() && b == a.get(i)){
                if(res.get(0) == -1 ){
                    res.set(0, i);
                    res.set(1, i);
                }
                else
                     res.set(1, i);
                i++;
                flag = true;
            }
        return res ;
    }
}
