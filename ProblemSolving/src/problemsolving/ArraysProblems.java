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
public class ArraysProblems {

    /*
     Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     For example:
     Given the array [-2,1,-3,4,-1,2,1,-5,4],
     the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     For this problem, return the maximum sum.
     */
    public int maxSubArray(int[] a) {
        int m = a[0];  //var m to save the max sum of contiguous array
        int[] s = new int[a.length]; // to know the last max in each state
        s[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            s[i] = Math.max(a[i], s[i - 1] + a[i]); // check which max a[i]  or last max +a[i]
            m = Math.max(m, s[i]);  // save the max 
        }
        return m;
    }

    /*
     Find out the maximum sub-array of non negative numbers from an array.
     The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
     Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
     Example:
     A : [1, 2, 5, -7, 2, 3]
     The two sub-arrays are [1, 2, 5] [2, 3].
     The answer is [1, 2, 5] as its sum is larger than [2, 3]
     NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
     NOTE 2: If there is still a tie, then return the segment with minimum starting index
     */
    // Solved by interviewBit
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }

    /*
     Given an array of integers, sort the array into a wave like array and return it, 
     In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

     Example
     Given [1, 2, 3, 4]
     One possible answer : [2, 1, 4, 3]
     Another possible answer : [4, 1, 3, 2]
     */
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> result = new ArrayList<>(a);

        for (int i = 0; i < a.size(); i++) {
            if (i == 0 || i % 2 == 0) {
                if (i == a.size() - 1) {
                    result.set(i, a.get(i));
                } else {
                    result.set(i + 1, a.get(i));
                }
            } else {
                result.set(i - 1, a.get(i));
            }

        }
        return result;
    }

    /*
     Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     You may assume that the intervals were initially sorted according to their start times.
     Example 1:
     Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
     Example 2:
     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
     This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     Make sure the returned intervals are also sorted.
     */
    public ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int start = -1, end = -1;
        boolean checkFlag = false, foundFlag = false;

        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end && !foundFlag) {
                start = i;
                checkFlag = true;
            }
            if (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end && !foundFlag) {
                end = i;
                if (start == end) {
                    result.add(new Interval(intervals.get(start).start, end));
                } else if (start == -1) {
                    result.add(new Interval(newInterval.start, intervals.get(end).end));
                } else {
                    result.add(new Interval(intervals.get(start).start, intervals.get(end).end));
                }
                checkFlag = false;
                foundFlag = true;
            }
            if (!checkFlag) {
                result.add(intervals.get(i));
            }
        }
        if (end == -1 && start == -1 && newInterval.end < intervals.get(0).start) {
            result.add(0, new Interval(newInterval.start, newInterval.end));
        }
        else if (end == -1 && start == -1 && newInterval.start < intervals.get(intervals.size() - 1).end) {
            result.add(new Interval(newInterval.start, newInterval.end));
        } else if (end == -1) {
            result.add(new Interval(newInterval.start, newInterval.end));
        }

        return result;
    }

}
