package com.industrialmojo.codilitity.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Flags {

    public static void main(String[] args) {
        final int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int solution = solution(A);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int[] A) {

        int previousPeakIndex = 0;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        Map<Integer, Integer> peaks = new HashMap<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                if (previousPeakIndex > 0) {
                    peaks.put(Integer.valueOf(i), Integer.valueOf(i - previousPeakIndex));
                    minDistance = Math.min(minDistance, i - previousPeakIndex);
                    maxDistance = Math.max(maxDistance, i - previousPeakIndex);
                } else {
                    peaks.put(Integer.valueOf(i), Integer.valueOf(0));
                }
                previousPeakIndex = i;
            }
        }

        System.out.println("Peaks : " + peaks.toString());
        System.out.println("minDistance : " + minDistance);
        System.out.println("maxDistance : " + maxDistance);

        if (minDistance >= peaks.size()) {
            return peaks.size();
        } else {
            return peaks.size() - 1;
        }
    }
}
