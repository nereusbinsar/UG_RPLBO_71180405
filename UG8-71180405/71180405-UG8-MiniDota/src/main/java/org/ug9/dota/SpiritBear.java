package org.ug9.dota;

public class SpiritBear extends SummonCharacter{

    public SpiritBear(int damage, int health, String name, Summoner owner) {
        super(damage, health, name, owner);
    }

    @Override
    public void attack(Creep enemy) {
        if (!(enemy.equals(getOwner()))){
            enemy.attacked(getDamage());
        }
    }
}
