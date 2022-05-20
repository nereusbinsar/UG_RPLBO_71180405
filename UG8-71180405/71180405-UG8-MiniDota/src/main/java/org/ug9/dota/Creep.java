package org.ug9.dota;

public class Creep extends Character implements AttackingHero{
    public Creep(int damage, int health, String name) {
        super(damage, health, name);
    }

    @Override
    public void attack(Hero hero) {
        hero.attacked(getDamage());
    }
}
