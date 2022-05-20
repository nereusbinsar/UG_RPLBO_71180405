package org.ug9.dota;

public class Warlock extends Hero implements Summoner{
    private int numOfSummon = 0;

    public Warlock(int damage, int health, String name) {
        super(damage, health, name);
    }

    @Override
    public void attack(Creep enemy) {
        enemy.attacked(getDamage());
    }

    @Override
    public Golem summon() {
        setNumOfSummon(1);
        return new Golem(this);
    }

    public void setNumOfSummon(int numOfSummon) {
        this.numOfSummon += numOfSummon;
    }
}
