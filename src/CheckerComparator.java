import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CheckerComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int ranking =  o2.getScore() - o1.getScore();

        if(ranking == 0) {
            int l1 = o1.getName().length();
            int l2 = o2.getName().length();
            for(int i = 0; i < (l1 < l2 ? l1 : l2); i++) {
                char c1 = o1.getName().charAt(i);
                char c2 = o2.getName().charAt(i);
                if(c1 != c2) {
                    return c1 - c2;
                }
            }
            if(l1 < l2) {
                return -2;
            } else if(l1 > l2) {
                return 1;
            } else {
                return 0;
            }
        }

        return ranking;
    }

    public static void main(String[] args) {
        CheckerComparator c = new CheckerComparator();
        List<Player> l = new ArrayList<>();
        l.add(new Player("b", 3));
        l.add(new Player("a", 1));
        l.add(new Player("bb", 3));
        l.add(new Player("b", 8));
        l.add(new Player("bba", 0));
        l.add(new Player("bb", 2));
        l.add(new Player("bca", 6));
        l.add(new Player("ccc", 4));
        l.add(new Player("b", 3));
        l.add(new Player("ab", 8));
        l.add(new Player("bb", 3));
        l.add(new Player("bb", 7));
        l.add(new Player("ccb", 8));
        l.add(new Player("bbb", 2));
        l.add(new Player("aab", 8));
        l.add(new Player("b", 6));
        l.add(new Player("ab", 8));
        l.add(new Player("cb", 9));
        l.add(new Player("cbb", 8));
        l.add(new Player("ba", 9));

        l.sort(c);

        System.out.println(l);
    }
}

class Player {
     String name;
     int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "[ " + this.getName() + " " + this.getScore()  +  "]";
    }
}
