// An example Java program for demonstrating HashTable and HashMap

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

class Teste {

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

        final String s1 = "Alvoroco";

        final String s2 = "Nescau";

        final String result = twoStrings(s1, s2);

    }
}
