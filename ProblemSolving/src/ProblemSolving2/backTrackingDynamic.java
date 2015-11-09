/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemSolving2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MHatem
 */
public class backTrackingDynamic {

    /*
    
     */
    public ArrayList fib(int n) {

        ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(n + 1, -1));
        memo.set(0, 0);
        memo.set(1, 1);

        calcFibonacci(n, memo);
        return memo;
    }

    private int calcFibonacci(int n, ArrayList<Integer> memo) {
        if (memo.get(n) != -1) {
            return memo.get(n);
        } else {
            memo.set(n, calcFibonacci(n - 2, memo) + calcFibonacci(n - 1, memo));
        }

        return memo.get(n);
    }

    /////////////////
    /*
     Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
     For example, given n = 3, a solution set is:
     "((()))", "(()())", "(())()", "()(())", "()()()"
    
     */
    public ArrayList<String> generateParenthesis(int a) {

        ArrayList<String> res = new ArrayList<>();
        String tmp = "";
        int left = 0, right = 0;
        calcParenthesis(a, tmp, res, left, right);

        return res;
    }

    private static void calcParenthesis(int n, String str, ArrayList<String> res, int left, int right) {
        if (left + right == n * 2) {
            res.add(str);
            return;
        }
        if (left == right) {
            calcParenthesis(n, str + "(", res, left + 1, right);
        }
        if (right < left) {
            if (left < n) {
                calcParenthesis(n, str + "(", res, left + 1, right);
            }
            calcParenthesis(n, str + ")", res, left, right + 1);
        }
    }

    /*
     Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     The same repeated number may be chosen from C unlimited number of times.
     */
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Collections.sort(a);

        calcuCombSum(res, a, tmp, 0, 0, b);

        return res;
    }

    private void calcuCombSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a, ArrayList<Integer> tmp, int index, int sum, int b) {

        if (sum == b && !res.contains(tmp)) {
            res.add(tmp);
            return;
        }
        if (sum > b) {
            return;
        }

        for (int i = index; i < a.size(); i++) {
            ArrayList<Integer> newTmp = new ArrayList<>(tmp);
            newTmp.add(a.get(i));
            calcuCombSum(res, a, newTmp, i, sum + a.get(i), b);
        }
    }

    /*
     The set [1,2,3,…,n] contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3 ) :

     1. "123"
     2. "132"
     3. "213"
     4. "231"
     5. "312"
     6. "321"
     Given n and k, return the kth permutation sequence.

     For example, given n = 3, k = 4, ans = "231"
     */
    public String getPermutation(int n, int k) {
        return null;
    }

    private void calculatePerm(int n, ArrayList<String> res, String tmp, int number) {
        if (tmp.length() == n) {
            res.add(tmp);
            return;
        }

        for (int i = 1; i <= n; i++) {
            tmp += Integer.toString(i);

        }
    }

    /**
     * Find the contiguous subarray within an array (containing at least one
     * number) which has the largest product. Return an integer corresponding to
     * the maximum product possible.
     */
    public int maxProduct(final List<Integer> a) {
        if (a == null || a.isEmpty()) {
            return 0;
        }

        int max = a.get(0), min = a.get(0), global = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            int tmp = max;
            max = Math.max(Math.max(a.get(i) * max, a.get(i)), min * a.get(i));
            min = Math.min(Math.min(a.get(i) * tmp, a.get(i)), min * a.get(i));
            global = Math.max(global, max);
        }
        return global;
    }
    /*
     You are climbing a stair case. It takes n steps to reach to the top.
     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    public int climbStairs(int a) {
        if (a < 0) {
            return 0;
        }

        int[] ways = new int[a + 1];
        ways[0] = ways[1] = 1;
        for (int i = 2; i < a + 1; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[a];
    }
    /*
     Given an array of non-negative integers, you are initially positioned at the first index of the array.
     Each element in the array represents your maximum jump length at that position.
     Determine if you are able to reach the last index.
     For example:
     A = [2,3,1,1,4], return 1 ( true ).
     A = [3,2,1,0,4], return 0 ( false ).
     */

    public int canJump(ArrayList<Integer> a) {
       if(a.size() <= 1)
           return 1;
        return jump(a,0,a.get(0),a.size()-1);
       
    }
    
    private int jump(ArrayList<Integer> a,int current,int maxJump,int target){
        if(current > target)
            return 0;
        
        for(int i = 1 ; i <= maxJump ; i++){
            if(i + current == target)
                return 1;
            if(jump(a, i+current, maxJump, target) == 1) 
                return 1;
        }
        return 0;
    }
}
