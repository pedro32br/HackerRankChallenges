import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class SherlockValidString {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(final String s) {
        final String isValid = "NO";

        final Map<Character, Integer> dictionary = new HashMap<>();
        final Map<Integer, Integer> freq = new HashMap<>();

        final char[] chars = s.toCharArray();

        for(final char c : chars) {
            if(dictionary.containsKey(c)) {
                freq.put(dictionary.get(c), freq.get(dictionary.get(c)) - 1);
                dictionary.put(c, dictionary.get(c) + 1);
                freq.put(dictionary.get(c), freq.getOrDefault(dictionary.get(c), 0) + 1);
            }
            else {
                freq.put(1, freq.getOrDefault(1, 0) + 1);
                dictionary.put(c, 1);
            }
        }

        final Set<Integer> set = dictionary.values().stream().collect(Collectors.toSet());

        if(set.size() == 1) {
            return "YES";
        }
        else if(set.size() == 2) {
            Integer count = 0;
            Integer freqCount = 0;
            boolean isRemoved = false;

            final List<Integer> list = set.stream().collect(Collectors.toList());

            for(final Integer x : list) {
                final Integer value = freq.get(x);
                if(value > 1 && count == 0) {
                    count = value;
                    freqCount = x;
                    continue;
                }
                if(isRemoved) {
                    return isValid;
                }
                if(value == 1 && (x + 1 == freqCount || x - 1 == freqCount)) {
                    isRemoved = true;
                }
                else {
                    return isValid;
                }
            }
            return "YES";
        }
        else {
            return isValid;
        }

    }

    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String s = bufferedReader.readLine();

        final String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
