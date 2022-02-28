import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(final String s) {
        int count = 0;
        char letter = ' ';
        for(int i = 0; i < s.length(); i++) {
            if(letter == s.charAt(i)) {
                count += 1;
            }
            else {
                letter = s.charAt(i);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int qItr = 0; qItr < q; qItr++) {
            final String s = scanner.nextLine();

            final int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
