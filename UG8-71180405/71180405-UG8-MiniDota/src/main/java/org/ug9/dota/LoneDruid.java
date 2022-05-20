package org.ug9.dota;

public class LoneDruid extends Hero implements Summoner, Upgradeable {
    private int killCreep = 0;
    private int level = 0;

    public LoneDruid(int damage, int health, String name) {
        super(damage, health, name);
    }

    @Override
    public void attack(Creep creep) {
        creep.attacked(this.getDamage());
        do{
            this.killCreep++;
        }
        while(creep.isDie());
    }

    @Override
    public SpiritBear summon() {
        return new SpiritBear(130, 1000, "Spirit Bear" , this);
    }

    @Override
    public void upgrade() {
        if (getKillCreep() >= 3) {
            setLevel(1);
            setKillCreep(-3);
            setName("Lone Druid +" + getLevel());
            setDamage(20);
        }
    }

    @Override
    public void showCharacterInfo() {
        super.showCharacterInfo();
        System.out.println("Kill Creep\t: " + getKillCreep());
    }

    public int getKillCreep() {
        return killCreep;
    }

    public void setKillCreep(int killCreep) {
        this.killCreep += killCreep;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    @Override
    public void  setDamage(int damage) {
        this.damage += damage;
    }
}
