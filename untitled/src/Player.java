public class Player {
    Inventory inventory;
    String name;
    boolean winController = false;
    int damage,healthy,money,Rhealty;
    boolean gameContinue = true;

    public Player(String name, int damage, int healthy, int money) {
        this.name = name;
        this.damage = damage;
        this.healthy = healthy;
        this.money = money;
        this.Rhealty = healthy;
        inventory = new Inventory();
    }
}
