package com.ash.srpg.items;

import com.ash.srpg.characters.ArmorType;

public class ItemArmor extends Item {

    protected ArmorType armor;

    protected int speed;

    protected String typeName;

    protected int weight;

    protected int slashDef;
    protected int stabDef;
    protected int bluntDef;
    protected int pierceDef;
    protected int bulletDef;
    protected int magicDef;

    protected int fireDef = 0;
    protected int iceDef = 0;
    protected int windDef = 0;
    protected int earthDef = 0;
    protected int lightningDef = 0;
    protected int divineDef = 0;
    protected int darkDef = 0;

    protected double poisonResist = 0;
    protected double woundResist = 0;
    protected double bleedResist = 0;
    protected double confusionResist = 0;
    protected double charmResist = 0;
    protected double enfeebleResist = 0;

    protected double burnResist = 0;
    protected double freezeResist = 0;
    protected double paralysisResist = 0;
    protected double silenceResist = 0;
    protected double blindResist = 0;
    protected double doomResist = 0;

    public ItemArmor() {
        super();
    }

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

    public void defineArmor(ArmorType type){
        armor = type;
        computeArmor();
    }

    public String toString(){
        String str = "ID: " + id + "\nName: " + name + "\nType: " + armor.getName()
                + "\nWeight: " + weight + "\nLore: " + flavor + "\n";
        str += "Fire Def: " + fireDef + "\nIce Def: " + iceDef + "\nWind Def: " + windDef
                + "\nEarth Def: " + earthDef + "\nLightning Def: " + lightningDef
                + "\nDivine Def: " + divineDef + "\nDark Def: " + darkDef + "\n\n";

        return str;
    }

    //<editor-fold desc="Setters">
    public void setArmor(ArmorType armor) {
        this.armor = armor;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void addSlashDef(int slashDef) {
        this.slashDef += slashDef;
    }

    public void addStabDef(int stabDef) {
        this.stabDef += stabDef;
    }

    public void addBluntDef(int bluntDef) {
        this.bluntDef += bluntDef;
    }

    public void addPierceDef(int pierceDef) {
        this.pierceDef += pierceDef;
    }

    public void addBulletDef(int bulletDef) {
        this.bulletDef += bulletDef;
    }

    public void addMagicDef(int magicDef) {
        this.magicDef += magicDef;
    }

    public void addFireDef(int fireDef) {
        this.fireDef += fireDef;
    }

    public void addIceDef(int iceDef) {
        this.iceDef += iceDef;
    }

    public void addWindDef(int windDef) {
        this.windDef += windDef;
    }

    public void addEarthDef(int earthDef) {
        this.earthDef += earthDef;
    }

    public void addLightningDef(int lightningDef) {
        this.lightningDef += lightningDef;
    }

    public void addDivineDef(int divineDef) {
        this.divineDef += divineDef;
    }

    public void addDarkDef(int darkDef) {
        this.darkDef += darkDef;
    }


    public void addPoisonResist(float poisonResist) {
        this.poisonResist += poisonResist;
    }

    public void addWoundResist(float woundResist) {
        this.woundResist += woundResist;
    }

    public void addBleedResist(float bleedResist) {
        this.bleedResist += bleedResist;
    }

    public void addConfusionResist(float confusionResist) {
        this.confusionResist += confusionResist;
    }

    public void addCharmResist(float charmResist) {
        this.charmResist += charmResist;
    }

    public void addEnfeebleResist(float enfeebleResist) {
        this.enfeebleResist += enfeebleResist;
    }

    public void addBurnResist(float burnResist) {
        this.burnResist += burnResist;
    }

    public void addFreezeResist(float freezeResist) {
        this.freezeResist += freezeResist;
    }

    public void addParalysisResist(float paralysisResist) {
        this.paralysisResist += paralysisResist;
    }

    public void addSilenceResist(float silenceResist) {
        this.silenceResist += silenceResist;
    }

    public void addBlindResist(float blindResist) {
        this.blindResist += blindResist;
    }

    public void addDoomResist(float doomResist) {
        this.doomResist += doomResist;
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public ArmorType getArmor() {
        return armor;
    }

    public int getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getWeight() {
        return weight;
    }

    public int getSlashDef() {
        return slashDef;
    }

    public int getStabDef() {
        return stabDef;
    }

    public int getBluntDef() {
        return bluntDef;
    }

    public int getPierceDef() {
        return pierceDef;
    }

    public int getBulletDef() {
        return bulletDef;
    }

    public int getMagicDef() {
        return magicDef;
    }

    public int getFireDef() {
        return fireDef;
    }

    public int getIceDef() {
        return iceDef;
    }

    public int getWindDef() {
        return windDef;
    }

    public int getEarthDef() {
        return earthDef;
    }

    public int getLightningDef() {
        return lightningDef;
    }

    public int getDivineDef() {
        return divineDef;
    }

    public int getDarkDef() {
        return darkDef;
    }

    public double getPoisonResist() {
        return poisonResist;
    }

    public double getWoundResist() {
        return woundResist;
    }

    public double getBleedResist() {
        return bleedResist;
    }

    public double getConfusionResist() {
        return confusionResist;
    }

    public double getCharmResist() {
        return charmResist;
    }

    public double getEnfeebleResist() {
        return enfeebleResist;
    }

    public double getBurnResist() {
        return burnResist;
    }

    public double getFreezeResist() {
        return freezeResist;
    }

    public double getParalysisResist() {
        return paralysisResist;
    }

    public double getSilenceResist() {
        return silenceResist;
    }

    public double getBlindResist() {
        return blindResist;
    }

    public double getDoomResist() {
        return doomResist;
    }
    //</editor-fold>
}
