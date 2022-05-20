package org.ug9.dota;

public class Golem extends SummonCharacter implements Summoner{
    private int kill = 0;

    public Golem(Summoner owner) {
        super(120, 1000, "Golem", owner);
    }

    @Override
    public void attack(Creep enemy) {
        enemy.attacked(getDamage());
        if (enemy.isDie()) {
            setKill(1);
        }
    }

    @Override
    public Golem summon() {
        if (getKill() > 0) {
            setKill(-1);
            return new Golem(this);
        }
        else{
            return null;
        }
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill += kill;
    }
}
