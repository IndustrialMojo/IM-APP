package com.industrialmojo.codilitity.lesson10;

public class CountFactors {

    public static void main(String[] args) {
        int solution = solution(4);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int A) {
        int factorCount = 2;
        for (int i = 2; i < A; i++) {
            if (A % i == 0) {
                factorCount++;
            }
        }

        int squareRootN = (int) Math.sqrt(A);
        if (Math.pow(squareRootN, 2) == A) {
            factorCount++;
        }

        return factorCount;
    }
}
