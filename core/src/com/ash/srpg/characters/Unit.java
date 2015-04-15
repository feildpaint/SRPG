package com.ash.srpg.characters;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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


        FileHandle file = Gdx.files.internal("data/test.dat");

        try {
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file.file()));

            vitality += Integer.parseInt(stream.readUTF());
            agility += Integer.parseInt(stream.readUTF());
            strength += Integer.parseInt(stream.readUTF());
            finesse += Integer.parseInt(stream.readUTF());
            willpower += Integer.parseInt(stream.readUTF());
            intellect += Integer.parseInt(stream.readUTF());
            luck += Integer.parseInt(stream.readUTF());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        String str;
        str  = "vitality: " + vitality + "\n";
        str  += "agility: " + agility + "\n";
        str  += "strength: " + strength + "\n";
        str  += "finesse: " + finesse + "\n";
        str  += "willpower: " + willpower + "\n";
        str  += "intellect: " + intellect + "\n";
        str  += "luck: " + luck;

        return str;
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
    //</editor-fold>




}
