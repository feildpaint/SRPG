package com.ash.srpg.characters;

public enum Race {

    HUMAN(1, 0, 0, 0, 2, 0, 0),
    ELF(0, 0, 0, 0, 0 , 0, 0),
    HALFLING(0, 0, 0, 0, 0 , 0, 0),
    DRAGONKIN(0, 0, 0, 0, 0 , 0, 0);


    private int vitality = 0;
    private int agility = 0;
    private int strength = 0;
    private int finesse = 0;
    private int willpower = 0;
    private int intellect = 0;
    private int luck = 0;

    private int[] stats;

    private Race(int vit, int agi, int str, int fin, int wil, int intl, int luk){
        vitality += vit;
        agility += agi;
        strength += str;
        finesse += fin;
        willpower += wil;
        intellect += intl;
        luck += luk;

        stats = new int[7];
        stats[0] = vitality;
        stats[1] = agility;
        stats[2] = strength;
        stats[3] = finesse;
        stats[4] = willpower;
        stats[5] = intellect;
        stats[6] = luck;
    }

    public int[] getStats() {
        return stats;
    }
}
