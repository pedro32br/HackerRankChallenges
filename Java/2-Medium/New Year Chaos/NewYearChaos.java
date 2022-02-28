import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q, int arraySize) {
        int bribes = 0;
        String chaos = "Too chaotic";
        Integer firstLine = 1;
        Integer secondLine = 2;
        Integer thirdLine = 3;

        for (int i = 0; i < arraySize; i++) {
            if(q[i] == firstLine){
                firstLine = secondLine;
                secondLine = thirdLine;
                thirdLine++;
            }else if(q[i] == secondLine){
                secondLine = thirdLine;
                thirdLine++;
                bribes+=1;
            } else if(q[i] == thirdLine){
                thirdLine++;
                bribes+=2;
            } else {
                System.out.println(chaos);
                return;
            }
        }
        System.out.println(bribes);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q, n);
        }

        scanner.close();
    }
}
