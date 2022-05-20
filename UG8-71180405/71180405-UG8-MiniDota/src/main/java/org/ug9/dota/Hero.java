package org.ug9.dota;

public abstract class Hero extends Character implements AttackingCreep {

    public Hero(int damage, int health, String name) {
        super(damage, health, name);
        setDamage(damage);
        setHealth(health);
        setName(name);
    }
}
