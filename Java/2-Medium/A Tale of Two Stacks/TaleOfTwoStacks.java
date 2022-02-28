import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TaleOfTwoStacks {
    public static void main(String[] args) {
        ArrayList<Integer> queue = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.add(queue.size(), scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.remove(0);
            } else if (operation == 3) { // print/peek
                System.out.println(queue.get(0));
            }
        }
        scan.close();
    }
}
