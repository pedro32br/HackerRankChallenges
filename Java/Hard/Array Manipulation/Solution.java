import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, long [] array) {

        long valor = 0;
        long max = 0;

        for(int i = 0; i < n; i++) {
            valor += array[i];
            max = Math.max(max, valor);
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long [] array = new long[n + 1];

        while(m-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            array[a - 1] += k;
            array [b] -= k;
        }

        long resultado = arrayManipulation(n, array);
        System.out.println(resultado);

        scanner.close();
    }
}
