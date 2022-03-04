import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(final BufferedReader bufferedReader, final int q) throws IOException {

        final HashMap<Integer, Integer> valuesToCounts = new HashMap<>();
        final HashMap<Integer, Set<Integer>> countsToValues = new HashMap<>();
        final ArrayList<Integer> results = new ArrayList<>();
        final int size = q;

        for(int i = 0; i < q; i++) {
            final String[] query = bufferedReader.readLine().split(" ");
            final int operation = Integer.parseInt(query[0]);
            final int number = Integer.parseInt(query[1]);

            final int oldCount = valuesToCounts.getOrDefault(number, 0);
            int newCount;

            if(operation == 1) {
                newCount = oldCount + 1;
                valuesToCounts.put(number, newCount);

                if(countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }
                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if(operation == 2) {
                newCount = (oldCount > 1) ? oldCount - 1 : 0;
                valuesToCounts.put(number, newCount);

                if(countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }

                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if(operation == 3) {
                if(number > size) {
                    results.add(0);
                }
                else {
                    results.add((number == 0 || countsToValues.getOrDefault(number, Collections.emptySet()).size() > 0) ? 1 : 0);
                }
            }
        }

        return results;
    }

    public static void main(final String[] args) throws IOException {
        try(final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            final int q = Integer.parseInt(bufferedReader.readLine().trim());

            final List<Integer> ans = freqQuery(bufferedReader, q);

            try(final BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
