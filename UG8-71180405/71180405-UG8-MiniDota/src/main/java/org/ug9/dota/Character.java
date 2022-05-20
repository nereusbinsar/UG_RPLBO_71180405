package org.ug9.dota;

public class Character {
    protected int damage,health;
    protected String name;

    public Character(int damage, int health, String name) {
        setDamage(damage);
        setHealth(health);
        setName(name);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDie(){
        if(this.getHealth() <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void attacked(int damage){
        this.health -= damage;
    }

    public void showCharacterInfo(){
        System.out.println("Character : " + getName() + "\n" +
                "Health : " + getHealth() + "\n" +
                "Damage : " + getDamage());
    }
}
