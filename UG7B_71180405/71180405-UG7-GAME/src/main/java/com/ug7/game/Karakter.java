package com.ug7.game;

public class Karakter {
    private Player player;
    private int HP = 100;
    private int money = 5000;
    private int weapon = 0;
    private boolean isWalk = false;

    public Karakter(Player player) {
        setPlayer(player);
    }

    public void buyWeapon(int weapon) {
        if(weapon > 0 && weapon < 5) {
            setWeapon(weapon);
        } else {
            System.out.println("pilihan yang kamu masukkan salah");
            return;
        }
        int price = switch (weapon) {
            case 1 -> 500;
            case 2 -> 3000;
            case 3 -> 2000;
            case 4 -> 4000;
            default -> 0;
        };
        if(this.money >= price) {
            this.money -= price;
            System.out.println("Berhasil membeli senjata! uang sekarang: " + this.getMoney());
        } else {
            System.out.println("Maaf uang kamu tidak mencukupi");
        }
    }

    public void abilityAttack(Karakter karakter) {
        karakter.receiveDamage(0);
    }

    public void normalAttack(Karakter karakter) {
        int damage = switch (this.getWeapon()) {
            case 1 -> 20;
            case 2 -> 60;
            case 3 -> 25;
            case 4 -> 50;
            default -> 0;
        };
        karakter.receiveDamage(damage);
    }

    public void receiveDamage(int damage) {
        this.HP -= damage;
        System.out.println(this.getPlayer()
                .getUsername() + " terkena serangan!sisa HP "
                + this.getPlayer().getUsername() + ": " + getHP()
        );

        if(this.getHP() <= 0) {
            this.HP = 0;
            System.out.println(this.getPlayer().getUsername() + " Mati");
        }
    }

    public void receiveHP(int hp) {
        this.HP += hp;
        if(this.getHP() >= 100) {
            setHP(100);
        }
        System.out.println("hp sekarang: " + getHP());
    }

    public void getInfo() {
        String deadStatus= "",move;
        System.out.println("username: " + getPlayer().getUsername());
        System.out.println("level: " + getPlayer().getLevel());
        System.out.println("money: " + getMoney());

        if(this.getHP() <= 0) {
            deadStatus = "[Mati]";
        }

        System.out.println("hp: " + this.getHP() + " " + deadStatus);
        String weapon = switch (this.weapon) {
            case 1 -> getWeaponList()[1];
            case 2 -> getWeaponList()[2];
            case 3 -> getWeaponList()[3];
            case 4 -> getWeaponList()[4];
            default -> getWeaponList()[0];
        };

        System.out.println("weapon: " + weapon);
        if(this.isWalk) {
            move = "berjalan";
        } else {
            move = "berlari";
        }
        System.out.println("movement: " + move + "\n");
    }

    public void walk(boolean type) {
        this.isWalk = type;
    }

    public Player getPlayer() {
        return player;
    }

    public int getHP() {
        return HP;
    }

    public int getMoney() {
        return money;
    }

    public int getWeapon() {
        return weapon;
    }

    public boolean isWalk() {
        return isWalk;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public String[] getWeaponList(){
        return new String[]{"knife","pisau","tongkat sihir","tongkat","katana"};
    }
}
