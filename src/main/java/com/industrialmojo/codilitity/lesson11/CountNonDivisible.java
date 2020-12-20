package com.industrialmojo.codilitity.lesson11;

public class CountNonDivisible {

    public static void main(String[] args) {
        final int[] A = {3, 1, 2, 3, 6};
        int[] solution = solution(A);
        System.out.println("The solution is: " + solution.toString());
    }

    private static int[] solution(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int nonDivisorCount = 0;
            for (int j = 0; j < A.length; j++) {
                if (i != j && A[i] % A[j] != 0) {
                    nonDivisorCount++;
                }
            }
            System.out.println(i + " : " + nonDivisorCount);
            result[i] = nonDivisorCount;
        }
        return result;
    }
}
