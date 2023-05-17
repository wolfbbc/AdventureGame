public class Cave extends BattleLoc{

    public Cave(Player player){
        this.player = player;
        obstacle = new Zombie();
    }
    void getLocation(){
        obsPiece = rand.nextInt(1,4);
        while (onLocition){
            int sel;
            if (obsPiece == 0){
                System.out.println("Burada hiç canavar yok lütfen daha sonra gelin");
                System.out.println("Çıkış yapmak için 2'ye basın");
                System.out.print("Seçim : ");
                sel = scanner.nextInt();
                while (sel != 2){
                    System.out.println("Hatalı seçim lütfen geçerli seçim yapınız");
                    sel = scanner.nextInt();
                }
            }
            else {
                System.out.println("Karşınızda "+obsPiece+" Adet Zombi var!");
                System.out.println("Karakter sağlık : " + player.healthy);
                System.out.println("Karakter hasar : " + player.damage);
                System.out.println("Zombi sağlık : " + obstacle.obsHealty);
                System.out.println("Zombi hasar : " + obstacle.obsDamage);
                System.out.println("1- Savaş");
                System.out.println("2- Kaç");
                System.out.print("Seçim : ");
                sel = scanner.nextInt();
                while (sel < 1 || sel > 2){
                    System.out.println("Hatalı seçim lütfen geçerli seçim yapınız");
                    sel = scanner.nextInt();
                }
            }

            switch (sel){
                case 1:
                    war();
                    break;
                case 2:
                    onLocition = false;
                    break;
                default:
                    break;
            }
        }


    }
    //Character and obstacle war
    void war(){
        for(int i = 1; i<= obsPiece;obsPiece--){
            int firstCombat = rand.nextInt(1,3);
            if (firstCombat == 1){
                while (player.healthy > 0 && obstacle.obsHealty > 0){
                    System.out.println("Canavara vurdunuz !");
                    obstacle.obsHealty -= player.damage;
                    System.out.println("Zombi sağlık : " + obstacle.obsHealty);
                    System.out.println("Zombi hasar : " + obstacle.obsDamage);
                    if (obstacle.obsHealty <= 0){
                        break;
                    }
                    System.out.println("Canavar size vurdu !");
                    player.healthy -= obstacle.obsDamage;
                    System.out.println("Karakter sağlık : " + player.healthy);
                    System.out.println("Karakter hasar : " + player.damage);


                }
            }
            else {
                while (player.healthy > 0 && obstacle.obsHealty > 0){
                    System.out.println("Canavar size vurdu !");
                    player.healthy -= obstacle.obsDamage;
                    System.out.println("Karakter sağlık : " + player.healthy);
                    System.out.println("Karakter hasar : " + player.damage);
                    if (player.healthy <= 0){
                        break;
                    }
                    System.out.println("Canavara vurdunuz !");
                    obstacle.obsHealty -= player.damage;
                    System.out.println("Zombi sağlık : " + obstacle.obsHealty);
                    System.out.println("Zombi hasar : " + obstacle.obsDamage);
                }
            }
            if (player.healthy <= 0){
                onLocition = false;
                player.gameContinue = false;
                System.out.println("Oyun Bitti! KAYBETTİNİZ :(");
                break;
            } else if (obstacle.obsHealty <= 0) {
                System.out.println("Canavarı öldürdünüz");
                System.out.println(obstacle.obsMoney + "Altın Kazandınız");
                player.money += obstacle.obsMoney;
                if ((obsPiece-1)==0){
                    System.out.println("Tüm canavarlar yok edildi ganimet olarak yemek kazandınız...");
                    player.inventory.food = true;
                    obsPiece = 0;
                    break;
                }else {
                    System.out.println("Kalan canavar : " + (obsPiece - 1));
                    System.out.println("Savaşmak için 1'e Kaçmak için 2'ye basınız...");
                }

                int newSel = scanner.nextInt();
                while (newSel < 1 || newSel > 2){
                    System.out.println("Lütfen geçerli bir seçim yapınız");
                    newSel = scanner.nextInt();
                }
                if (newSel == 1){
                    obstacle = new Zombie();

                }else {
                    obsPiece = obsPiece-1;
                    break;
                }
            }
        }

    }
}
