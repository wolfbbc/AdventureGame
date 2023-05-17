public class ToolStore extends NormalMap{

    public ToolStore(Player player){
        this.player = player;
    }

    boolean weopenForKey = true;
    boolean armorForKey = true;
    @Override
    void getLocation() {
        menu();
    }
    void menu(){
        while (onLocition){
            System.out.println("Lütfen gitmek istediğiniz mağazayı seçiniz");
            System.out.println("1- SİLAHLAR");
            System.out.println("2- ZIRHLAR");
            System.out.println("3- ÇIKIŞ ");
            int selTool = scanner.nextInt();
            while (selTool < 1 || selTool > 3){
                System.out.println("Lütfen geçerli bir seçim giriniz");
                selTool = scanner.nextInt();
            }
            if (selTool == 1){
                weopenForKey = true;
                buyWeapon();
            }
            else if (selTool == 2)
            {
                armorForKey = true;
                armorWeapon();
            } else if (selTool == 3) {
                onLocition = false;
            }
        }


    }

    //WEAPON BUY
    void buyWeapon(){
        while (weopenForKey){
            System.out.println("Lütfen silah seçiniz");
            System.out.println("1- TABANCA -- HASAR : 2 FİYAT : 25");
            System.out.println("2- KILIÇ   -- HASAR : 3 FİYAT : 35");
            System.out.println("3- TÜFEK   -- HARAR : 7 FİYAT : 45");
            System.out.println("4- ÇIKIŞ");
            int selectItem = scanner.nextInt();
            while (selectItem < 1 || selectItem > 4){
                System.out.println("Lütfen geçerli bir seçim yapınız");
                selectItem = scanner.nextInt();
            }
            switch (selectItem){
                case 1:
                    if (player.money >= 25){
                        weaponInfo("Tabanca",2,25);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 2:
                    if (player.money >= 35){
                        weaponInfo("Kılıç",3,35);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 3:
                    if (player.money >= 45){
                        weaponInfo("Tüfek",7,45);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 4:
                    weopenForKey  = false;
                    break;
                default:
                    break;
            }
        }

    }

    void weaponInfo(String name,int damage,int price){
        this.player.inventory.weaponName = name;
        if (player.inventory.weaponRdamage > 0){
            player.damage -= player.inventory.weaponRdamage;
            player.inventory.weaponRdamage = damage;
        }else {
            player.inventory.weaponRdamage = damage;
        }

        this.player.inventory.weaponDamage = damage;
        this.player.money -= price;
        this.player.damage += damage;
        System.out.println("TOPLAM HASARINIZ : " + this.player.damage);
        System.out.println("PARANIZ : " + this.player.money);
    }

    //WEAPON ARMOR

    void armorWeapon(){
        while (armorForKey){
            System.out.println("Lütfen zırh seçiniz");
            System.out.println("1- HAFİF  -- DEFANS : 2 FİYAT : 15");
            System.out.println("2- ORTA   -- DEFANS : 3 FİYAT : 25");
            System.out.println("3- AĞIR   -- DEFANS : 7 FİYAT : 40");
            System.out.println("4- ÇIKIŞ");
            int selcArmor = scanner.nextInt();
            while (selcArmor < 1 || selcArmor > 4){
                System.out.println("Lütfen geçerli bir seçim yapnız");
                selcArmor = scanner.nextInt();
            }
            switch (selcArmor){
                case 1:
                    if (player.money >= 25){
                        armorInfo("Hafif",2,15);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 2:
                    if (player.money >= 35){
                        armorInfo("Orta",3,25);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 3:
                    if (player.money >= 45){
                        armorInfo("Ağır",7,40);
                    }else {
                        System.out.println("Yetersiz bakiye");
                    }
                    break;
                case 4:
                    armorForKey = false;
                    break;
                default:
                    break;
            }
        }

    }

    void armorInfo(String name,int defance,int price){
        player.inventory.armorName = name;
        if (player.inventory.armorRdefence > 0){
            player.healthy -= player.inventory.armorRdefence;
            player.inventory.armorRdefence = defance;
        }
        else {
            player.inventory.armorRdefence = defance;
        }
        player.inventory.armorDefence = defance;
        player.healthy += defance;
        player.money -= price;

        System.out.println("GÜNCEL SAĞLIĞINIZ : " + player.healthy);
        System.out.println("GÜNCEL PARA : " + player.money);
    }
}
