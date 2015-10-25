/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.ArrayList;
import java.util.Collections;

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
                i = (start + end) / 2;
            } else if (target < arr.get(i)) {
                end = i - 1;
                i = (start + end) / 2;
            }
        }
        return i;
    }

    //nOT cOMPLETE :)
    public ArrayList<Integer> searchRange(ArrayList<Integer> a, int b) {

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        boolean flag = false;
        int i = a.size() / 2, start = 0, end = a.size();
        while (b != a.get(i)) {
            if (b > a.get(i)) {
                start = i + 1;
                i = (start + end) / 2;
            } else if (b < a.get(i)) {
                end = i - 1;
                i = (start + end) / 2;
            } else {
                while (i >= 0 && a.get(i) == b) {
                    i--;
                    flag = true;
                }
            }
            if (flag) {
                break;
            }

        }
        i++;
        while (i < a.size() && b == a.get(i)) {
            if (res.get(0) == -1) {
                res.set(0, i);
                res.set(1, i);
            } else {
                res.set(1, i);
            }
            i++;
            flag = true;
        }
        return res;
    }

    /*
     Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
     Return the sum of the three integers. 
     You may assume that each input would have exactly one solution.

     Example: 
     given array S = {-1 2 1 -4}, 
     and target = 1.

     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
     */
    public int threeSumClosest(ArrayList<Integer> a, int b) {

        int res = 0, sum;
        int diff = Integer.MAX_VALUE;
        int i, j, k;
        Collections.sort(a);
        for (i = 0; i < a.size(); i++) {
            j = i + 1;
            k = a.size()-1;
            while (j < a.size() && k > i && j!= k) {
                sum = a.get(i) + a.get(j) + a.get(k);
                if (sum == b) {
                    return b;
                } else {
                    if (diff > (Math.abs(b - sum))) {
                        diff = Math.abs(b - sum);
                        res = sum;
                    }
                }
                if(sum > b)
                    k -- ;
                else
                    j++;
            }

        }

        return res;
    }
}
