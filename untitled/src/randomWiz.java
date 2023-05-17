import java.util.Random;

public class randomWiz {
    Random rand = new Random();
    Player player;
    public randomWiz(Player player){
        this.player = player;
    }
    void randomWizard(){
        int rand1 = rand.nextInt(1,101);
        int rand2 = rand.nextInt(1,101);

        if (rand1 <= 15){
            if (rand2 <= 20){
                System.out.println("Tüfek Kazandınız");
                player.inventory.weaponDamage = 7;
                player.inventory.weaponName = "Tüfek";
            } else if (rand2 > 20 && rand2 <= 50) {
                System.out.println("Kılıç Kazandınız");
                player.inventory.weaponName = "Kılıç";
                player.inventory.weaponDamage = 3;
            } else if (rand2 > 50 && rand2 <= 100) {
                System.out.println("Tabanca Kazandınız");
                player.inventory.weaponName = "Tabanca";
                player.inventory.weaponDamage = 2;
            }
        } else if (rand1 > 15 && rand1 <= 30) {
            if (rand2 <= 20){
                System.out.println("Ağır Zırh Kazandınız");
                player.inventory.armorDefence = 5;
                player.inventory.armorName = "Ağır Zırh";
            } else if (rand2 > 20 && rand2 <= 50) {
                System.out.println("Orta Zırh Kazandınız");
                player.inventory.armorName = "Orta Zırh";
                player.inventory.armorDefence = 3;
            } else if (rand2 > 50 && rand2 <= 100) {
                System.out.println("Hafif zırh Kazandınız");
                player.inventory.armorName = "Hafif Zırh";
                player.inventory.armorDefence = 1;
            }
        } else if (rand1 > 30 && rand1 <= 55) {
            if (rand2 <= 20){
                System.out.println("10 Altın Kazandınız");
                player.money += 10;
            } else if (rand2 > 20 && rand2 <= 50) {
                System.out.println("5 Altın Kazandınız");
                player.money += 5;
            } else if (rand2 > 50 && rand2 <= 100) {
                System.out.println("1 Altın Kazandınız");
                player.money += 1;
            }
        } else if (rand1 > 55 && rand1 <= 100) {
            System.out.println("Hiçbir şey kazanamadınız");
        }
    }
}
