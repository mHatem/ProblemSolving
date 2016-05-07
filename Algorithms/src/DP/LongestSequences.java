/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author MHatem
 */
public class LongestSequences {
    
    /**
     * 
     * @param str1
     * @param str2
     * @return the longest common seq between 2 strings 
     */
    public String longestCommonSeq(String str1, String str2){
        StringBuilder lcs = new StringBuilder();
        int i = 0;
        int j = 0;
        int savej = 0;
        while(i < str1.length() && j < str2.length() ){
            if(str1.charAt(i) == str2.charAt(j)){
                lcs.append(str1.charAt(i));
                savej = j;
                i++;
                j++;
            }
            else
                j++;
            if(j == str2.length() && i < str1.length()){
                j = savej +1 ;
                i++;
            }
        }
        return lcs.toString();
    }
    
    /**
     *
     * @param str1
     * @param str2
     * @return the length of longest common seq between 2 strings
     */
    public int longestCommonSeqLength(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
         int [][] L =  new int[n+1][m+1];
        
         for(int i = 0 ; i <= n ; i ++){
             for(int j = 0 ; j <= m ; j ++){
                 if(i ==0 || j == 0 )
                     L[i][j] = 0;
                 else if(str1.charAt(i-1) == str2.charAt(j-1))
                     L[i][j] = L[i-1][j-1] + 1;
                 else
                     L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
             }
         }
         
         return L[n][m];
        
    }
     /**
      * Find the length of the longest subsequence of a given sequence such that all elements of 
      * the subsequence are sorted in increasing order. For example, 
      * length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
      * @param arr
      * @return length of the  longest subsequence of a given sequence
      */
     public int longestIncresingSeq (int[] arr){
         int count [] = new int[arr.length];
         int max = 0;
         count[arr.length-1] = 1;
         for(int i = arr.length-2 ; i >= 0 ; i--){
               for(int j = i+1 ; j < arr.length ; j ++){
                 if(arr[i] < arr[j]){
                     count[i] = count[j] + 1;
                     break;
                 }
             }
             max = Math.max(max,count[i]);
         }
         return max;
     }
}
