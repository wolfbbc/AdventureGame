import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location{
    Obstacle obstacle;
    Player player;
    Random rand = new Random();
    int obsPiece;
}
