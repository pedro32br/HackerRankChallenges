import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(final int n, final int[] ar) {
        int pairs = 0;
        final ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(list.isEmpty() || !list.contains(ar[i])) {
                list.add(ar[i]);
            }
            else {
                final int finalI = i;
                list.removeIf(x -> x == ar[finalI]);
                pairs += 1;
            }
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final int[] ar = new int[n];

        final String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0; i < n; i++) {
            final int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        final int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
