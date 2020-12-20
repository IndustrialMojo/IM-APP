package com.industrialmojo.codilitity.lesson10;

import java.util.Stack;

public class Peaks {

    public static void main(String[] args) {
        final int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        int solution = solution(A);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int[] A) {

        Stack peaks = new Stack();
        int previousPeakIndex = 0;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.push(i);
                if (previousPeakIndex > 0) {
                    minDistance = Math.min(minDistance, i - previousPeakIndex);
                    maxDistance = Math.max(maxDistance, i - previousPeakIndex);
                }
                previousPeakIndex = i;
            }
        }

        System.out.println("Peaks : " + peaks.toString());
        System.out.println("minDistance : " + minDistance);
        System.out.println("maxDistance : " + maxDistance);


int sub = A.length/peaks.size();

//        for ()




        if (minDistance >= peaks.size()) {
            return peaks.size();
        } else {
            return peaks.size() - 1;
        }
    }
}
