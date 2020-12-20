package com.industrialmojo.codilitity.lesson12;

public class ChocolatesByNumbers {

    public static void main(String[] args) {
        final int N = 10;
        final int M = 4;

        int solution = solution(N, M);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int N, int M) {

        boolean[] chocolates = new boolean[N];
        boolean isWrapper = false;
        int nextIndex = 0;
        int lastIndex = N - 1;
        int runningCount = 0;

        while (!isWrapper) {

            isWrapper = chocolates[nextIndex];

            if (!isWrapper) {

                System.out.println(nextIndex);

                chocolates[nextIndex] = true;
                runningCount++;
                int i = nextIndex + M;
                nextIndex = (i > lastIndex) ? i - N : i;
            }
        }

        return runningCount;
    }
}
