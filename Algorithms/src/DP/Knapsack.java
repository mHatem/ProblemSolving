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
public class Knapsack {

    public int knapSack(int W, int wt[], int val[], int l) {
        if (W == 0 || l == 0) {
            return 0;
        }
        if (val[l - 1] > W) {
            return knapSack(W, wt, val, l - 1);
        } else {
            return Math.max(val[l - 1] + knapSack(W - wt[l - 1], wt, val, l - 1),
                    knapSack(W, wt, val, l - 1)
            );
        }
    }

    public int knapSackDP(int Weight, int wt[], int val[], int l) {
        int i, j = 0;
        int[][] k = new int[l + 1][Weight+ 1];

        for (i = 0; i <= l; i++) {
            for (j = 0; j <= Weight; j++) {
                if (i==0 || j==0)
                    k[i][j] = 0;
                else if(wt[i-1] <= j)
                     k[i][j] = Math.max(val[i-1] + k[i-1][j-wt[i-1]],  k[i-1][j]);
                else
                 k[i][j] = k[i-1][j];
            }
        }
        
       return k[l][j]; 
    }

}
