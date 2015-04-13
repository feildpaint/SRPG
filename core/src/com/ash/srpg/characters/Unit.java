package com.ash.srpg.characters;


public class Unit {

    // stats
    private int vitality;
    private int agility;
    private int strength;
    private int finesse;
    private int willpower;
    private int intellect;
    private int luck;

    private Race race;

    public Unit(Race newRace) {
        race = newRace;
        int[] stats = race.getStats();

        vitality += stats[0];
        agility += stats[1];
        strength += stats[2];
        finesse += stats[3];
        willpower += stats[4];
        intellect += stats[5];
        luck += stats[6];
    }
}
