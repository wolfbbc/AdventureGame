import java.util.Scanner;

public abstract class Location {
    Player player;
    boolean onLocition = true;
    protected Scanner scanner = new Scanner(System.in);
    abstract void getLocation();
}
