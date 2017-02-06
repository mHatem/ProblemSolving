/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author MHatem
 */
public class EditDistance {

    /**
     * Given two strings str1 and str2 and below operations that can performed
     * on str1. Find minimum number of edits (operations) required to convert
     * ‘str1′ into ‘str2′.
     *
     * Insert Remove Replace All of the above operations are of equal cost.
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int count[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    count[i][j] = j;
                } else if (j == 0) {
                    count[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] = Math.min(Math.min(count[i - 1][j], count[i][j - 1]), count[i - 1][j - 1]) + 1;
                }
            }
        }

        return count[n][m];
    }

    /**
     * Given a distance ‘dist, count total number of ways to cover the distance
     * with 1, 2 and 3 steps.
     *
     * @param A
     * @return
     */
    public int printCountRec(int dist) {

        if (dist < 0) {
            return 0;
        } else if (dist == 0) {
            return 1;
        }

        return printCountRec(dist - 1) + printCountRec(dist - 2) + printCountRec(dist - 3);

    }

    /**
     * Given a distance ‘dist, count total number of ways to cover the distance
     * with 1, 2 and 3 steps. DP
     *
     * @param dist
     * @return
     */
    public int printCountRecDP(int dist) {
        int[] dists = new int[dist + 1];
        dists[0] = 1;
        dists[1] = 1;
        dists[2] = 2;
        if (dist < 3) {
            return dists[dist];
        }

        for (int i = 3; i <= dist; i++) {
            dists[i] = dists[i - 1] + dists[i - 2] + dists[i - 3];
        }
        return dists[dist];
    }
}
