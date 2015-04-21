package com.ash.srpg.characters;

public enum Race {

    HUMAN       ("Human",       1,  0,  0,  0,  2,   0,  0),
    ELF         ("Elf",         0,  2, -1,  2,  0 ,  0,  0),
    HALFLING    ("Halfling",    0,  0,  0,  0,  0 ,  2,  1),
    DRAGONKIN   ("Dragonkin",   1,  0,  3, -1,  0 ,  0,  0);


    private int vitality = 0;
    private int agility = 0;
    private int strength = 0;
    private int finesse = 0;
    private int willpower = 0;
    private int intellect = 0;
    private int luck = 0;

    private String title;

    private int[] stats;

    private Race(String title, int vit, int agi, int str, int fin, int wil, int intl, int luk){
        this.title = title;
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

    //<editor-fold desc="Getters">
    public int getVitality() {
        return vitality;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public int getFinesse() {
        return finesse;
    }

    public int getWillpower() {
        return willpower;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getLuck() {
        return luck;
    }

    public int[] getStats() {
        return stats;
    }

    public String getTitle() {
        return title;
    }
    //</editor-fold>
}
