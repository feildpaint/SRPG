package com.ash.srpg.characters;

import com.ash.srpg.items.*;

import java.util.ArrayList;

public class CharacterType extends Unit {

    private Race race;

    private ItemArmorHead armorHead;
    private ItemArmorChest armorChest;
    private ItemArmorLegs armorLegs;
    private ItemArmorHands armorHands;
    private ItemArmorFeet armorFeet;

    private ArrayList<Item> inventory;

    public CharacterType(Race race) {
        super();
        this.race = race;
        computeRace();

        calculateSubstats();
    }

    private void computeRace(){
        vitality += race.getVitality();
        agility += race.getAgility();
        strength += race.getStrength();
        finesse += race.getFinesse();
        willpower += race.getWillpower();
        intellect += race.getIntellect();
        luck += race.getLuck();
    }

    public String toString(){
        String str = "Race: " + race.getTitle() + "\n";
        str += super.toString();

        return str;
    }

    //<editor-fold desc="Getters">
    public Race getRace() {
        return race;
    }

    public ItemArmorHead getArmorHead() {
        return armorHead;
    }

    public ItemArmorChest getArmorChest() {
        return armorChest;
    }

    public ItemArmorLegs getArmorLegs() {
        return armorLegs;
    }

    public ItemArmorHands getArmorHands() {
        return armorHands;
    }

    public ItemArmorFeet getArmorFeet() {
        return armorFeet;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    //</editor-fold>
}
