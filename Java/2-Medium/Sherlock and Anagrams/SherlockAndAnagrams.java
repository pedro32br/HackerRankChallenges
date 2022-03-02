import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SherlockAndAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(final String s) {
        int count = 0;

        final ArrayList<String> list = new ArrayList();
        final Set<String> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            for(int k = i + 1; k <= s.length(); k++) {
                final char[] subStrings = s.substring(i, k).toCharArray();
                Arrays.sort(subStrings);
                list.add(String.valueOf(subStrings));
                set.add(String.valueOf(subStrings));
            }
        }

        for(int i = 0; i < list.size(); i++) {
            for(int k = i + 1; k < list.size(); k++) {
                if(list.get(i).equals(list.get(k))) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(final String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                final String s = bufferedReader.readLine();

                final int result = SherlockAndAnagrams.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
            catch(final IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
