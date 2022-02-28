import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if(a.score < b.score)
            return -1;
        if(a.score > b.score)
            return 1;
        return a.name.compareTo(b.name);
    }
}


public class SortingComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner("davis 15\n" +
                "davis 20\n" +
                "davis 10\n" +
                "edgehill 15");
        int n = 4;

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
