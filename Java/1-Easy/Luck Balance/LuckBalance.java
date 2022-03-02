import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LuckBalance {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(final int k, final List<List<Integer>> contests) {
        int maxLuck = 0;
        final List<Integer> important = new ArrayList<>();

        for(int i = 0; i < contests.size(); i++) {

            if(contests.get(i).get(1) == 0) {
                maxLuck += contests.get(i).get(0);
            }
            else {
                important.add(contests.get(i).get(0));
            }
        }

        important.sort(Comparator.reverseOrder());

        for(int i = 0; i < important.size(); i++) {
            if(i < k) {
                maxLuck += important.get(i);
            }
            else {
                maxLuck -= important.get(i);
            }
        }

        return maxLuck;

    }

    public static void main(final String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        final int n = Integer.parseInt(firstMultipleInput[0]);

        final int k = Integer.parseInt(firstMultipleInput[1]);

        final List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                contests.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            }
            catch(final IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        final int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
