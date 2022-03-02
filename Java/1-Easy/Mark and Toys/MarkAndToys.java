import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class MarkAndToys {

    public static int maximumToys(final List<Integer> prices, int k) {
        int count = 0;
        final List<Integer> sorted = prices.stream().sorted().collect(toList());
        for(final Integer i : sorted) {
            if(k - i >= 0) {
                ++count;
                k -= i;
            }
        }

        return count;

    }

    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        final int n = Integer.parseInt(firstMultipleInput[0]);

        final int k = Integer.parseInt(firstMultipleInput[1]);

        final List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        final int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
