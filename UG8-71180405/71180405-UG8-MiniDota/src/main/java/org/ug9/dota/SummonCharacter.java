package org.ug9.dota;

public abstract class SummonCharacter extends Hero{
    protected Summoner owner;
    private int damage,health;
    private String name;

    public SummonCharacter(int damage, int health, String name, Summoner owner) {
        super(damage, health, name);
        setDamage(damage);
        setHealth(health);
        setName(name);
        setOwner(owner);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Summoner getOwner() {
        return owner;
    }

    public void setOwner(Summoner owner) {
        this.owner = owner;
    }

    public abstract void attack(Creep enemy);
}
