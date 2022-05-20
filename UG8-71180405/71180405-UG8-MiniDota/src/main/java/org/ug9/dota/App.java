package org.ug9.dota;


public class App 
{
    public static void main( String[] args )
    {
        Creep creepSatu = new Creep(20, 200, "creep satu");
        Creep creepDua = new Creep(20, 200, "creep dua");
        Creep creepTiga = new Creep(20, 200, "creep tiga");
        LoneDruid loneDruid = new LoneDruid(140, 1800, "Lone Druid");
        Warlock warlock = new Warlock(80, 700, "Warlock");
        SpiritBear spiritBear = loneDruid.summon();
        Golem golem = warlock.summon();
        creepDua.attack(spiritBear);
        creepDua.attack(warlock);
        loneDruid.attack(creepSatu);
        spiritBear.attack(creepDua);
        warlock.attack(creepTiga);
        spiritBear.attack(creepDua);
        warlock.attack(creepTiga);
        golem.attack(creepSatu);
        golem.attack(creepDua);
        Golem miniGolem = golem.summon();
        loneDruid.showCharacterInfo();
        System.out.println();
        spiritBear.showCharacterInfo();
        System.out.println();
        miniGolem.showCharacterInfo();
    }
}
