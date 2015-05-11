package com.ash.srpg.items;

import com.ash.srpg.characters.WeaponType;

public class ItemWeapon extends Item {

    protected WeaponType weaponType;

    protected String weaponTypeName;

    protected int speed;

    protected int slashAtk;
    protected int stabAtk;
    protected int bluntAtk;
    protected int pierceAtk;
    protected int bulletAtk;
    protected int magicAtk;

    protected int baseDef;

    protected int fireAtk = 0;
    protected int iceAtk = 0;
    protected int windAtk = 0;
    protected int earthAtk = 0;
    protected int lightningAtk = 0;
    protected int divineAtk = 0;
    protected int darkAtk = 0;

    public ItemWeapon(WeaponType weaponType) {
        super();
        this.weaponType = weaponType;
        calculateStats();
    }

    protected void calculateStats(){
        weaponTypeName = weaponType.getname();
        speed = weaponType.getSpeed();
        slashAtk = weaponType.getSlashDmg();
        stabAtk = weaponType.getStabDmg();
        bluntAtk = weaponType.getBluntDmg();
        pierceAtk = weaponType.getPierceDmg();
        bulletAtk = weaponType.getBulletDmg();
        magicAtk = weaponType.getMagicDmg();
        baseDef = weaponType.getBaseDef();
    }

    //<editor-fold desc="Getters">
    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSlashAtk() {
        return slashAtk;
    }

    public int getStabAtk() {
        return stabAtk;
    }

    public int getBluntAtk() {
        return bluntAtk;
    }

    public int getPierceAtk() {
        return pierceAtk;
    }

    public int getBulletAtk() {
        return bulletAtk;
    }

    public int getMagicAtk() {
        return magicAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getFireAtk() {
        return fireAtk;
    }

    public int getIceAtk() {
        return iceAtk;
    }

    public int getWindAtk() {
        return windAtk;
    }

    public int getEarthAtk() {
        return earthAtk;
    }

    public int getLightningAtk() {
        return lightningAtk;
    }

    public int getDivineAtk() {
        return divineAtk;
    }

    public int getDarkAtk() {
        return darkAtk;
    }

    //</editor-fold>

}
