import java.util.*;

public class IceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> values = new HashMap();
        for (int i = 0; i < cost.length; i++) {
            if (values.keySet().contains(money - cost[i])) {
                System.out.println(String.format("%s %s", values.get(money - cost[i]), i+1));
                break;
            }
            values.put(cost[i], i+1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
