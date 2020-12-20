package com.industrialmojo.codilitity.lesson09;

import java.util.TreeSet;

public class MaxProfit {

    public static void main(String[] args) {
        final int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        int solution = solution(A);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int[] A) {
        TreeSet<Integer> resultsZ = new TreeSet<Integer>();
        resultsZ.add(Integer.valueOf(0));
        for (int i : A) {
            TreeSet<Integer> resultsA = new TreeSet<Integer>();
            resultsA.add(Integer.valueOf(0));
            for (int j = 1; j < A.length; j++) {
                int diff = A[j] - i;
                if (diff > 0) {
                    resultsA.add(Integer.valueOf(diff));
                }
            }
            System.out.println(resultsA);
            resultsZ.add(resultsA.last());
        }
        System.out.println(resultsZ);
        return resultsZ.last().intValue();
    }
}
