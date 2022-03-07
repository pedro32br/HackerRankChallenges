import java.util.Arrays;
import java.util.Scanner;

public class ZigZagSequence {

    public static void main(final String[] args) throws java.lang.Exception {
        final Scanner kb = new Scanner(System.in);
        final int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++) {
            final int n = kb.nextInt();
            final int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = kb.nextInt();
            }
            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(final int[] a, final int n) {
        Arrays.sort(a);
        final int mid = (n - 1) / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
