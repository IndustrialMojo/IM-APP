package com.industrialmojo.codilitity.lesson12;

import java.util.ArrayList;
import java.util.List;

public class CommonPrimeDivisors {

    public static void main(String[] args) {

        final int[] A = new int[]{15, 10, 3};
        final int[] B = new int[]{75, 30, 5};

        int result = solution(A, B);
        System.out.println("result : " + result);
    }

    private static int solution(int[] A, int[] B) {

        int result = 0;

        for (int i = 0; i < A.length; i++) {

            int a = A[i];
            int b = B[i];

            List<Integer> primeList = getPrimeList(Math.max(a, b));

            boolean isMatch = false;

            for (Integer j : primeList) {

                int x = j.intValue();

                boolean booA = (x < a && a % x == 0);
                boolean booB = (x < b && b % x == 0);

                if (booA && booB) {
                    isMatch = true;
                    System.out.println("a: " + a + ", b: " + b + ", j: " + j);
                } else if (booA || booB) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                result++;
            }
        }

        return result;
    }

    private static List<Integer> getPrimeList(int N) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(Integer.valueOf(i));
            }
        }
        System.out.println("primeList : " + primeList.toString());
        return primeList;
    }
}
