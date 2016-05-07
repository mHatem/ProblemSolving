/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author MHatem
 */
public class Others {

    public int kthsmallest(final List<Integer> a, int k) {
        ArrayList<Integer> indexs = new ArrayList<>();
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) < min && !indexs.contains(j)) {
                    min = a.get(j);
                    index = j;
                }
            }
            indexs.add(index);
            min = Integer.MAX_VALUE;

        }
        return a.get(indexs.get(indexs.size() - 1));
    }

    public int kthsmallest2(final List<Integer> a, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        int i;
        for (i = 0; i < k; i++) {
            queue.add(-a.get(i));
        }
        for (i = k; i < a.size(); i++) {
            if ((a.get(i) * -1) > queue.peek()) {
                queue.poll();
                queue.add(a.get(i) * -1);
            }
        }
        return queue.peek() * -1;
    }
    /*
     Given an array of integers, find two numbers such that they add up to a specific target number.
     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
     Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
     */

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i))) {
                res.add(map.get(a.get(i)) + 1);
                res.add(i + 1);
                break;
            } else {
                map.put(b - a.get(i), i);
            }
        }

        return res;
    }

    /*
     Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

     Example: 
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.
     */
    public int longestConsecutive(final List<Integer> a) {
       int max = 0 ;
        Set input =new HashSet(a);
       for(int i = 0 ; i< a.size() ; i++){
           int smaller = a.get(i)-1;
           int greater = a.get(i)+1;
           int count = 1;
           while(input.contains(smaller)){
               count ++;
               input.remove(smaller);
                 smaller --;
           }
           while(input.contains(greater)){
               count ++;
               input.remove(greater);
               greater++;
           }
           if(count > max)
               max = count;
       }
       
        return max;
    }
    
    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        while(i < a.size())
        {
 
                if(Objects.equals(a.get(i), a.get(i+1))){
                    a.remove(i+1);
                }
                else
                    i++;
        }
        return a.size();
    }
}
