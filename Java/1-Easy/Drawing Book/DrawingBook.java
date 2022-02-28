import java.io.*;
import java.util.*;

public class DrawingBook {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(Math.min(p/2, n/2 - p/2));
    }
}
