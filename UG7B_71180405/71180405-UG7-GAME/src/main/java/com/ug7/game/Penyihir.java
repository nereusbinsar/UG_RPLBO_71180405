package com.ug7.game;

public class Penyihir extends Karakter {
    private boolean isAbilityReady;

    public Penyihir(Player player) {
        super(player);
    }

    public void buyWeapon(int weapon) {
        System.out.println("Daftar senjata:");
        for(int index = 1; index < getWeaponList().length; index++){
            System.out.println(index + ". " + getWeaponList()[index]);
        }
        System.out.println("Pilihan senjata: " + weapon);
        if(weapon == 2 || weapon == 3) {
            super.buyWeapon(weapon);
        } else {
            System.out.println("Sebagai penyihir kamu hanya boleh membeli tongkat/tongkat sihir");
        }
    }

    public void abilityAttack(Karakter karakter) {
        if(isAbilityReady()) {
            int healing;
            if (isWalk()) {
                healing = karakter.getHP() / 2;
            } else {
                healing = 100;
            }
            System.out.println("Tidak semudah itu, " + karakter.getPlayer().getUsername()+ "");
            super.receiveHP(healing);
        } else {
            System.out.println("Ability belum aktif");
        }
    }

    public void normalAttack(Karakter karakter) {
        if(isWalk()) {
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
                this.isAbilityReady = true;
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
            System.out.println(this.getPlayer().getUsername() + " terbang! (Lari)");
        }
        super.walk(type);
    }

    public void getInfo() {
        System.out.println("[Karakter Penyihir]");
        super.getInfo();
    }

    public boolean isAbilityReady() {
        return isAbilityReady;
    }
}
