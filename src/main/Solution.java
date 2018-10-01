package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void extractDigits(HashSet < Integer > set, long a) {
        String str = String.valueOf(a);
        for (int j = 0; j < str.length(); j++) {
            set.add(Character.getNumericValue(str.charAt(j)));
        }
    }

    public static boolean allNumbersExist(HashSet < Integer > set) {
        for (int k = 0; k <= 9; k++) {
            if (!set.contains(k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int T;
        long N;
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        do {
            T = sc.nextInt();
        } while (T < 1 || T > 100);
        long arr[] = new long[T];
        for (int a = 0; a < T; a++) {
            do {
                N = sc.nextInt();
            } while (N < 0 || N > Math.pow(10, 6));
            arr[a] = N;
        }
        for (int a = 0; a < T; a++) {
            if (arr[a] == 0)
                System.out.println("Case #" + (a + 1) + ": " + "INSOMNIA");
            else {
                HashSet < Integer > setOfNumbers = new HashSet < Integer > ();
                extractDigits(setOfNumbers, arr[a]);

                int coeff = 1;
                long res = 0;
                while (allNumbersExist(setOfNumbers) == false) {

                    coeff++;
                    res = arr[a] * coeff;
                    extractDigits(setOfNumbers, res);

                }

                System.out.println("Case #" + (a + 1) + ": " + res);
            }
        }
    }

}
