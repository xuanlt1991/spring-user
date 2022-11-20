package com.spring.springuser;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i+=2) {
            if (i == (A.length - 1)) {
                return A[i];
            }
            if (A[i] != A[i+1]) {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int x = 20;
        String bin = Integer.toBinaryString(x );
        System.out.println("Binary: " + bin);
        int count = 0;
        int maximum = 0;
        for (int i = 0; i < bin.length(); i++) {
            /*if (i == (bin.length()) - 1) {
                break;
            }*/
            if (bin.charAt(i) == '0') {
                count++;
            } else {
                maximum = Integer.max(maximum, count);
                count = 0;
            }
        }

        System.out.println("Maximum: " + maximum);
    }
}
