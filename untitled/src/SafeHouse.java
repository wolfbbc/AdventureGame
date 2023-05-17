public class SafeHouse extends NormalMap{

    public SafeHouse(Player player){
        this.player = player;
    }
    @Override
    void getLocation() {
       if (player.inventory.water && player.inventory.food&&player.inventory.firewood){
           player.winController = true;
       }
       System.out.println("CANINIZ YENİLDENDİ");
       player.healthy = player.Rhealty;
       System.out.println("Canınız : " + player.healthy);
    }
}
