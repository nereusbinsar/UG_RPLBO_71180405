package com.ug7.game;

public class Ninja extends Karakter {
    private boolean isAbilityReady;

    public Ninja(Player player) {
        super(player);
    }

    public void buyWeapon(int weapon) {
        System.out.println("Daftar senjata:");
        for(int index = 1; index < getWeaponList().length; index++){
            System.out.println(index + ". " + getWeaponList()[index]);
        }
        System.out.println("pilihan senjata: " + weapon);
        if(weapon == 1 || weapon == 4) {
            super.buyWeapon(weapon);
        } else {
            System.out.println("Sebagai ninja kamu hanya boleh membeli pisau / katana");
        }
    }

    public void abilityAttack(Karakter karakter) {
        int damage;
        if(isAbilityReady()) {
            damage = karakter.getHP() / 2;
            if(!isWalk()) {
                damage = karakter.getHP();
            }
            System.out.println("rasakan ini, " + karakter.getPlayer().getUsername()+ "");
            karakter.receiveDamage(damage);
            if(karakter.getHP() == 0) {
                this.getPlayer().levelUp();
            }
        } else {
            System.out.println("ability belum aktif");
        }
    }

    public void normalAttack(Karakter karakter) {
        if(this.getWeapon() == 0) {
            System.out.println("Sorry, " + this.getPlayer().getUsername() +
                    "... Silakan beli senjata terlebih dahulu");
            return;
        }
        if(!isWalk()) {
            int damage = switch (this.getWeapon()) {
                case 1 -> 20;
                case 2 -> 60;
                case 3 -> 25;
                case 4 -> 50;
                default -> 0;
            };
            damage *= 1.5;
            karakter.receiveDamage(damage);
            if(karakter.getHP() < 50) {
                setAbilityReady(true);
            }
            if(karakter.getHP() == 0) {
                this.getPlayer().levelUp();
            }
        } else {
            super.normalAttack(karakter);
        }
    }

    public void walk(boolean type) {
        if(!type) {
            System.out.println(this.getPlayer().getUsername() + " menghilang (Lari)");
        }
        super.walk(type);
    }

    public void getInfo() {
        System.out.println("[Karakter Ninja]");
        super.getInfo();
    }

    public boolean isAbilityReady() {
        return isAbilityReady;
    }

    public void setAbilityReady(boolean abilityReady) {
        isAbilityReady = abilityReady;
    }
}
