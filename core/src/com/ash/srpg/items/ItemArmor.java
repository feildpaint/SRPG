package com.ash.srpg.items;

import com.ash.srpg.characters.ArmorType;

public class ItemArmor extends Item {

    protected ArmorType armor;

    protected int speed;

    protected int slashDef;
    protected int stabDef;
    protected int bluntDef;
    protected int pierceDef;
    protected int bulletDef;
    protected int magicDef;

    protected String typeName;

    protected int weight;

    public ItemArmor(int id, String name, String flavor, ArmorType armor, int weight) {
        super(id, name, flavor);
        this.armor = armor;
        this.weight = weight;
        computeArmor();
    }

    protected void computeArmor() {
        speed = armor.getSpeed();
        slashDef = armor.getSlashDef();
        stabDef = armor.getStabDef();
        bluntDef = armor.getBluntDef();
        pierceDef = armor.getPierceDef();
        bulletDef = armor.getBulletDef();
        magicDef = armor.getMagicDef();
        typeName = armor.getName();
    }

}
