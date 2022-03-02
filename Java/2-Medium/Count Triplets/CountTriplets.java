import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(final List<Long> arr, final long r) {
        Long cont = 0L;

        final Map<Long, Long> before = new HashMap<>();
        final Map<Long, Long> after = new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {
            if(after.containsKey(arr.get(i))) {
                after.put(arr.get(i), after.get(arr.get(i)) + 1);
            }
            else {
                after.put(arr.get(i), 1L);
            }
        }

        for(int i = 0; i < arr.size(); i++) {
            if(after.containsKey(arr.get(i))) {
                after.put(arr.get(i), after.get(arr.get(i)) - 1);
            }
            else {
                after.put(arr.get(i), 0L);
            }
            if(arr.get(i) % r == 0 && before.containsKey(arr.get(i) / r) && after.containsKey(arr.get(i) * r)) {
                cont += before.get(arr.get(i) / r) * after.get(arr.get(i) * r);
            }

            if(before.containsKey(arr.get(i))) {
                before.put(arr.get(i), before.get(arr.get(i)) + 1);
            }
            else {
                before.put(arr.get(i), 1L);
            }
        }

        return cont;
    }

    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        final int n = Integer.parseInt(nr[0]);

        final long r = Long.parseLong(nr[1]);

        final List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        final long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
