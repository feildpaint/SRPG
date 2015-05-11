package com.ash.srpg.characters;

import com.ash.srpg.items.*;

import java.util.ArrayList;

public class CharacterType extends Unit {

    private static final int MAX_CLASSES = 3;

    private Race race;

    private ItemArmorHead armorHead;
    private ItemArmorChest armorChest;
    private ItemArmorLegs armorLegs;
    private ItemArmorHands armorHands;
    private ItemArmorFeet armorFeet;

    private ItemWeapon currentWeapon;

    private ArrayList<Item> inventory;

    private ArrayList<ClassType> classes;

    public CharacterType(Race race) {
        super();
        this.race = race;
        inventory = new ArrayList<>();
        classes = new ArrayList<>();
        computeRace();

        setCurrentWeapon(new ItemWeapon(WeaponType.SHORTSWORD));
        addClass(ClassType.WARRIOR);

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

    public void calculateClass(){
        for (ClassType type : classes){

        }
    }

    public void setCurrentWeapon(ItemWeapon weapon){
        currentWeapon = weapon;
    }

    public void addClass(ClassType type){
        if (!(classes.size() > MAX_CLASSES))
            classes.add(type);
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

    public ArrayList<ClassType> getClasses() {
        return classes;
    }

    //</editor-fold>
}
