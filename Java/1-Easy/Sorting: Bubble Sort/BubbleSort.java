import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BubbleSort {

    public static void countSwaps(final List<Integer> list, final Integer n) {

        Integer swapCount = 0;

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for(int max = n - 1; max > 0; max--) {
                for(int i = 0; i < list.size() - 1; i++) {
                    final int left = list.get(i);
                    final int right = list.get(i + 1);
                    if(left > right) {
                        swapped = true;
                        ++swapCount;
                        list.set(i + 1, left);
                        list.set(i, right);
                    }
                }
            }
        }

        final Optional<Integer> min = list.stream().min(Comparator.naturalOrder());
        final Optional<Integer> max = list.stream().max(Comparator.naturalOrder());

        System.out.println("Array is sorted in " + swapCount + " swaps.\n"
                + "First Element: " + min.get() + "\n"
                + "Last Element: " + max.get());
    }

    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine().trim());

        final List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        countSwaps(a, n);

        bufferedReader.close();
    }
}
