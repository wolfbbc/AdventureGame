import java.util.Random;

public class Snake extends Obstacle{
    Random rand = new Random();
    Player player;
    public Snake(){
        obsName = "Snake";
        obsDamage = rand.nextInt(3,7);
        obsHealty = 12;
    }

    //Random Wizard


}
