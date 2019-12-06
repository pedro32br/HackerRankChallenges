import java.io.*;
import java.util.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        Integer sum = null;
        int compare = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < 4; j++) {
                compare += arr[i][j] + arr[i][j+1] + arr[i][j+2];
                compare += arr[i+1][j+1];
                compare += arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(sum == null || compare > sum)
                    sum = compare;
                compare = 0;
            }
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner("-1 -1 0 -9 -2 -2\n" +
            "-2 -1 -6 -8 -2 -5\n" +
            "-1 -1 -1 -2 -3 -4\n" +
            "-1 -9 -2 -4 -4 -5\n" +
            "-7 -3 -3 -2 -9 -9\n" +
            "-1 -3 -1 -2 -4 -5");

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        scanner.close();
    }
}
