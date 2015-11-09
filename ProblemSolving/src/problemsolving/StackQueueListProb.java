/*
 * To change this license aer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemsolving;

import DataStructure.Stack;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author MHatem
 */
public class StackQueueListProb {

    public ListNode reverseLinkedListRec(ListNode a) {
        ListNode snode;
        ListNode rnode;
        if (a.next == null) {
            return a;
        }
        snode = a.next;
        a.next = null;
        rnode = reverseLinkedListRec(snode);
        snode.next = a;

        return rnode;
    }

    public ListNode reverseLinkedList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode p1 = a;
        ListNode p2 = a.next;

        a.next = null;
        while (p1 != null && p2 != null) {

            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            if (t != null) {
                p2 = t;
            } else {
                break;
            }
        }

        return p2;
    }

    /*
     Given a singly linked list, modify the value of first half nodes 
    
     Example:
     Given linked list 1 -> 2 -> 3 -> 4 -> 5
     You should return 4 -> 2 -> 3 -> 4 -> 5
     */
    public ListNode subtract(ListNode a) {
        int size = 0;
        ListNode tmp = a;
        ListNode tmp2 = null;

        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        size = size / 2;
        tmp = a;
        Stack s = new Stack();
        int i = 0;
        while (tmp != null) {
            if (i >= size) {
                s.push(tmp);
            }
            tmp = tmp.next;
            i++;
        }
        tmp = a;
        i = 0;
        while (i < size) {
            tmp.val = ((ListNode) s.pop()).val - tmp.val;
            tmp = tmp.next;
            i++;
        }
        return a;
    }

    /*
     Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
     More formally,
     
     Example:
     Input : A : [4, 5, 2, 10]
     Output : [5, 10, 10, -1] 
     */
    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean flg = false;
        for (int i = 0; i < a.size(); i++) {
            for(int j = i +1 ; j < a.size() ; j ++){
                if(a.get(j) > a.get(i)){
                    res.add(a.get(j));
                    flg = true;
                    break;
                }
              
            }
              if(!flg)
                    res.add(-1);
                flg = false;
        }
        return res;
    }
}
