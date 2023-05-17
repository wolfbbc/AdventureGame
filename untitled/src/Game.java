import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);
    void start(){
        selectCharecter();
        //winControl
        while (player.gameContinue){
            if (player.winController){
                System.out.println("Tüm ödülleri toplayarak oyunu kazandınız");
            }
            gameContinues();
        }

    };


    //Select character
    void selectCharecter(){
        System.out.println("Lütfen karakter seçiniz");
        System.out.println("1- Samuray  -- Hasar : 5  Sağlık : 21  Para : 15");
        System.out.println("2- Okçu     -- Hasar : 7  Sağlık : 18  Para : 20");
        System.out.println("3- Şovalye  -- Hasar : 8  Sağlık : 24  Para : 5");
        int selectChar = scanner.nextInt();
        while (selectChar < 1 || selectChar > 3){
            System.out.println("Hatalı karakter seçimi lütfen tekrar seçin");
            selectChar = scanner.nextInt();
        }
        switch (selectChar){
            case 1:
                player = new Player("Samuray",5,21,15);
                break;
            case 2:
                player = new Player("Okçu",7,18,20);
                break;
            case 3:
                player = new Player("Şovalye",8,24,100);
                break;
            default:
                player = new Player("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter başarı ile oluşturuldu karakteriniz");
        System.out.println("Karakter : " + player.name);
        System.out.println("Karakter Hasar : " + player.damage);
        System.out.println("Karakter Sağlık : " + player.healthy);
        System.out.println("Karakter Para : " + player.money);
    }

    //characte Info

    void charcInfo(){
        System.out.println("Karakter bilgileri");
        System.out.println("------------------------------");
        System.out.println("KARAKTER SAĞLIK : " + player.healthy);
        System.out.println("KARAKTER HASAR : " + player.damage);
        System.out.println("KARAKTER PARA : " + player.money);
        System.out.println("------------------------------");
        System.out.println();

    }


    //Continues Game

    void gameContinues(){
        charcInfo();
        //Select menu
        System.out.println("Lütfen gitmek istediğiniz yeri seçiniz");
        System.out.println();
        System.out.println("1-Güvenli Ev (Can yenilenir.)");
        System.out.println("2-Mağaza (Zırh ve Silah alınabilr)");
        System.out.println("3-Mağara (Karşınıza zombi çıkabilir(1-3))");
        System.out.println("4-Orman (Karşınıza Vampir çıkabilir(1-3))");
        System.out.println("5-Nehir (Karşınıza Ayı çıkabilir)(1-3)");
        System.out.println("6-Maden (Karşınıza Yılan çıkabilir(3-6))");
        System.out.print("Seçim : ");
        int selLoc = scanner.nextInt();

        while (selLoc < 1 || selLoc > 6){
            System.out.println("Hatalı seçim lütfen tekrar seçiniz");
            selLoc = scanner.nextInt();
        }
        switch (selLoc){
            case 1:
                location = new SafeHouse(player);
                location.getLocation();
                break;
            case 2:
                location = new ToolStore(player);
                location.onLocition = true;
                location.getLocation();
                break;
            case 3:
                if (player.inventory.food){
                    System.out.println("Bu haritadaki tüm düşmaları öldürdünüz artık buraya giremezsiniz");
                    break;
                }else {
                    location = new Cave(player);
                    location.onLocition = true;
                    location.getLocation();
                    break;
                }

            case 4:
                if (player.inventory.firewood){
                    System.out.println("Bu haritadaki tüm düşmaları öldürdünüz artık buraya giremezsiniz");
                    break;
                }else {
                    location = new Forest(player);
                    location.onLocition = true;
                    location.getLocation();
                    break;
                }

            case 5:
                if (player.inventory.water){
                    System.out.println("Bu haritadaki tüm düşmaları öldürdünüz artık buraya giremezsiniz");
                    break;
                }else {
                    location = new River(player);
                    location.onLocition = true;
                    location.getLocation();
                    break;
                }
            case 6:
                location = new Coal(player);
                location.onLocition = true;
                location.getLocation();
                break;
            default:
                System.out.println("EVDESİNİZ");
                break;
        }

    }


}
