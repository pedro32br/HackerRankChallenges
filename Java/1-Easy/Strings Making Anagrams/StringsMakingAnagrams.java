import java.io.*;
import java.util.*;

public class StringsMakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] lettercounts = new int[26];
        for(char c : a.toCharArray()){
            lettercounts[c-'a']++;
        }
        for(char c : b.toCharArray()){
            lettercounts[c-'a']--;
        }
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
