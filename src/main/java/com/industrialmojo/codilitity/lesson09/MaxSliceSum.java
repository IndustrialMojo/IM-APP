package com.industrialmojo.codilitity.lesson09;

import java.util.TreeSet;

public class MaxSliceSum {

    public static void main(String[] args) {
        final int[] A = {3, 2, -6, 4, 0};
        int solution = solution(A);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int[] A) {
        TreeSet<Integer> resultsZ = new TreeSet<Integer>();
        for (int i = 0; i < A.length - 1; i++) {
            TreeSet<Integer> resultsA = new TreeSet<Integer>();
            int runningSum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                runningSum = runningSum + A[j];
                resultsA.add(Integer.valueOf(runningSum));
            }
            System.out.println(resultsA);
            resultsZ.add(resultsA.last());
        }
        System.out.println(resultsZ);
        return resultsZ.last().intValue();
    }
}
