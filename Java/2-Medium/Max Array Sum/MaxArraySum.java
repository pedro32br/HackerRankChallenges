import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(final int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        arr[0] = Math.max(0, arr[0]);

        if(arr.length == 1) {
            return Math.max(arr[1], arr[0]);
        }

        arr[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
        }

        return arr[arr.length - 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final int[] arr = new int[n];

        final String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0; i < n; i++) {
            final int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        final int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
