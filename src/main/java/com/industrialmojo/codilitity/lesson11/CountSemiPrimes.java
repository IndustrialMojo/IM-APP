package com.industrialmojo.codilitity.lesson11;

import java.util.*;

public class CountSemiPrimes {

    public static void main(String[] args) {

        final int N = 26;
        final int[] P = new int[]{1, 4, 16};
        final int[] Q = new int[]{26, 10, 20};
        int[] result = solution(N, P, Q);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] solution(int N, int[] P, int[] Q) {

        int[] result = new int[P.length];

        Set<Integer> semiPrimeSet = getSemiPrimeSet(N);

        int runningCount;
        for (int i = 0; i < P.length; i++) {
            runningCount = 0;
            for (Integer j : semiPrimeSet) {
                int x = j.intValue();
                if (x >= P[i] && x <= Q[i]) {
                    runningCount++;
                } else if (x > Q[i]) {
                    break;
                }
            }
            result[i] = runningCount;
        }

        return result;
    }

    private static boolean[] getIsPrimeArray(int N) {

        boolean[] isPrimeArray = new boolean[N + 1];
        isPrimeArray[0] = false;
        isPrimeArray[1] = true;

        for (int i = 2; i <= N; i++) {
            isPrimeArray[i] = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeArray[i] = false;
                    break;
                }
            }
        }

        for (int i = 0; i <= isPrimeArray.length - 1; i++) {
            if (isPrimeArray[i]) {
                System.out.println(i + ", ");
            }
        }
        return isPrimeArray;
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
        for (Integer i : primeList) {
            System.out.println("prime : " + i);
        }
        return primeList;
    }

    private static Set<Integer> getSemiPrimeSet(int N) {

        Set<Integer> semiPrimeSet = new TreeSet<>();
        List<Integer> primeList = getPrimeList(N);

        for (Integer i : primeList) {
            int x = i.intValue();
            for (Integer j : primeList) {
                int y = j.intValue();
                int z = x * y;
                if (z > N) {
                    break;
                } else {
                    semiPrimeSet.add(Integer.valueOf(z));
                }
            }
        }
        for (Integer i : semiPrimeSet) {
            System.out.println("semi-prime : " + i);
        }
        return semiPrimeSet;
    }
}
