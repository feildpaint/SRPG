package com.ash.srpg.characters;

@SuppressWarnings("unused")
public enum ClassType {

    //<editor-fold desc="Types">
    WARRIOR(new int[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            new int[] {  0,  0,  0,  0,  0,  0,  0});
    //</editor-fold>

    private int[] weaponList = new int[29];
    private int[] armorList = new int[7];

    ClassType(int[] weaponList, int[] armorList) {
        this.weaponList = weaponList;
        this.armorList = armorList;
    }


}
