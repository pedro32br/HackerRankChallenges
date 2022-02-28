import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

public class TwoStrings {

    private static String twoStrings(final String s1, final String s2) {
        final HashMap c1 = new HashMap<String, String>();
        for(final char x : s1.toCharArray()) {
            c1.put(x, "NO");
        }
        for(final char y : s2.toCharArray()) {
            final Optional optional = Optional.ofNullable(c1.get(y));
            if(optional.isPresent()) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(final String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                final String s1 = bufferedReader.readLine();

                final String s2 = bufferedReader.readLine();

                final String result = twoStrings(s1, s2);

                bufferedWriter.write(result);
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
