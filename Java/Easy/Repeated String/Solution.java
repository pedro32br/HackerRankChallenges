import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long as = s.chars().filter(ch -> ch == 'a').count();
        long times = n/s.length();
        long res = 0;
        long x = n%s.length();
        if((int)x > 0)
            res = s.substring(0, (int)x).chars().filter(ch -> ch == 'a').count();
        return as * times + res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println(repeatedString(s, n));

        scanner.close();
    }
}
