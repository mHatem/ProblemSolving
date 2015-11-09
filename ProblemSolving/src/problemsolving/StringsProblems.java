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
public class StringsProblems {

    /*
     Print triangle
     */
    public String printTringle(int n) {
        String tri="";

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                tri += "*";
            }
            tri +="\n";
        }
        
        return tri;
    }
    /*
     Write a function to find the longest common prefix string amongst an array of strings.
     Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
     As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
     */

    public String longestCommonPrefix(ArrayList<String> a) {

        if (a.isEmpty()) {
            return null;
        }
        for (int i = 0; i < a.get(0).length(); i++) {
            char c = a.get(0).charAt(i);
            for (int j = 1; j < a.size(); j++) {
                if (i >= a.get(j).length()
                        || a.get(j).charAt(i) != c) {
                    // Mismatch found
                    return a.get(j).substring(0, i);
                }
            }
        }
        return a.get(0);
    }

    /*
     Given an input string, reverse the string word by word.
     Example:
     Given s = "the sky is blue",
     return "blue is sky the".
     */
    public String reverseWords(String a) {
        String[] str = a.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            if (!"\\s".equals(str[i]) && !"".equals(str[i])) {
                sb.append(str[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

    /*
    
     */
    public int atoi(final String a) {
        StringBuilder number = new StringBuilder();
        String numbers = "-0123456789";
        boolean flag = false;

        for (int j = 0; j < a.length(); j++) {
            while (j < a.length() && numbers.contains(a.charAt(j) + "")) {
                flag = true;
                number.append(a.charAt(j));
                j++;
            }
            if (flag) {
                return Integer.parseInt(number.toString());
            }
        }
        return 0;
    }

    public int strStr(final String haystack, final String needle) {
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }
        int index = -1, j = 0;
        boolean flag = false;

        for (int i = 0; i < haystack.length(); i++) {
            index = i;
            while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                flag = true;
                i++;
                j++;
            }
            if (flag && needle.length() == j) {
                return index;
            } else {
                i -= j;
                j = 0;

            }

        }
        return -1;
    }

    //////////////////////////////////////////////////Roman2Int///////////////////
    /*
     Given a roman numeral, convert it to an integer.
     */
    public int romanToInt(String a) {
        a = a.toUpperCase();
        int number = 0, lastDigit = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            char toDigit = a.charAt(i);

            switch (toDigit) {
                case 'M':
                    number = calculateDigits(1000, lastDigit, number);
                    lastDigit = 1000;
                    break;
                case 'D':
                    number = calculateDigits(500, lastDigit, number);
                    lastDigit = 500;
                    break;
                case 'C':
                    number = calculateDigits(100, lastDigit, number);
                    lastDigit = 100;
                    break;
                case 'L':
                    number = calculateDigits(50, lastDigit, number);
                    lastDigit = 50;
                    break;
                case 'X':
                    number = calculateDigits(10, lastDigit, number);
                    lastDigit = 10;
                    break;
                case 'V':
                    number = calculateDigits(5, lastDigit, number);
                    lastDigit = 5;
                    break;
                case 'I':
                    number = calculateDigits(1, lastDigit, number);
                    lastDigit = 1;
                    break;
                default:
                    return 0;
            }
        }
        return number;
    }

    public int calculateDigits(int digit, int lastDigit, int lastNumber) {
        if (lastDigit > digit) {
            return lastNumber - digit;
        } else {
            return lastNumber + digit;
        }
    }
    /////////////////////////////////////////////////////////////////////
    /*
     Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
     You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
     Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
     Extra spaces between words should be distributed as evenly as possible.
     If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
     For the last line of text, it should be left justified and no extra space is inserted between words.
     Your program should return a list of strings, where each string represents a single line.
     */

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {

        return null;
    }

    /*
     Given a string S, find the longest palindromic substring in S.
     Input : "aaaabaaa"
     Output : "aaabaaa"
     //Not compleleted :)
     */
    public String longestPalindrome(String a) {
        if (a.length() == 0) {
            return "";
        }

        StringBuilder tmp = new StringBuilder(a);
        String reverseStr = tmp.reverse().toString();
        tmp = new StringBuilder();
        String res = "";
        for (int i = 0; i < a.length(); i++) {

            while (i < a.length() && a.charAt(i) == reverseStr.charAt(i)) {
                tmp.append(a.charAt(i));
                i++;
            }
            if (tmp.length() > res.length()) {
                res = tmp.toString();
                tmp = new StringBuilder();
            }
        }
        return res;
    }
}
