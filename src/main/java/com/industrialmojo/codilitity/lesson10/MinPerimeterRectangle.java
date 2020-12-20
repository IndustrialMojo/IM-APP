package com.industrialmojo.codilitity.lesson10;

public class MinPerimeterRectangle {

    public static void main(String[] args) {
        int solution = solution(30);
        System.out.println("The solution is: " + solution);
    }

    private static int solution(int A) {
        int minPerimeter = Integer.MAX_VALUE;
        int squareRoot = (int) Math.sqrt(A);
        if (Math.pow(squareRoot, 2) != A) {
            squareRoot++;
        }
        for (int i = 1; i <= squareRoot; i++) {
            if (A % i == 0) {
                minPerimeter = Math.min(minPerimeter, 2 * (i + (A/i)));
            }
        }
        return minPerimeter;
    }
}
