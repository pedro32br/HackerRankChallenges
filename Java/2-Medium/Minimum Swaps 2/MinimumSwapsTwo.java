import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwapsTwo {

    static int minimumSwaps(final int[] arr) {

        int minimumSwaps = 0;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != i + 1) {
                    final int wrong1 = arr[i];
                    final int wrong2 = arr[wrong1 - 1];

                    arr[i] = wrong2;
                    arr[wrong1 - 1] = wrong1;

                    ++minimumSwaps;
                    swapped = true;
                }
            }
        }

        return minimumSwaps;
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

        final int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
