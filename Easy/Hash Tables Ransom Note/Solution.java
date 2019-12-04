import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        /**
         * Hashmap is quicker than Hashtable but is not thread-safe
         * Any questions about Hashtable x Hashmap check this website:
         * https://www.gangboard.com/blog/hashmap-vs-hashtable/
         */
        HashMap<String, Integer> table = new HashMap<>();
        String answer = "Yes";
        for (int i = 0; i < magazine.length; i++) {
            if(table.containsKey(magazine[i]))
                table.put(magazine[i], table.get(magazine[i]) + 1);
            else
                table.put(magazine[i],1);
        }
        for (int i = 0; i < note.length; i++) {
            if(!table.containsKey(note[i])) {
                answer = "No";
                break;
            }
            int cont = table.get(note[i]) - 1;

            if(cont == 0)
                table.remove(note[i]);
            else
                table.put(note[i], cont);
        }
        System.out.println(answer);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}