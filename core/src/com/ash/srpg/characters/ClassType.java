package com.ash.srpg.characters;


@SuppressWarnings("SpellCheckingInspection")
public enum ClassType {

    //<editor-fold desc="Types">
    WARRIOR     ("Warrior" ,
                 1.3f,1.25f,1.05f, 1.1f, 1.2f, 1.2f,1.25f, 1.2f, 1.1f,  1f, 0.8f, 0.9f,  1f, 0.7f,
                 0.5f, 0.3f, 0.4f, 0.1f, 0.1f,1.15f,1.25f, 1.3f,   1f,  1f,   1f,   1f,  1f,   1f,
                 0.6f, 0.7f, 0.9f,   1f, 1.2f, 1.3f,   1f),
    KNIGHT      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Warrior"),
    ARCHER      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Archer"),
    PALADIN     (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Paladin"),
    BANDIT      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Bandit"),
    ASSASSIN    (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Assassin"),
    SABOTEUR    (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Saboteur"),
    BRAWLER     (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Brawler"),
    BERSERKER   (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Berserker"),
    HUNTER      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Hunter"),
    DRUID       (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Druid"),
    GUNNER      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Gunner"),
    PRIEST      (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Priest"),
    MAGICIAN    (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Magician"),
    ELEMENTALIST(new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Elementalist"),
    TEMPEST     (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Tempest Mage"),
    PYROMANCER  (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Pyromancer"),
    TERRA       (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Terra Mage"),
    CLAIRVOYANT (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Clarivoyant"),
    DARKMAGE    (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Dark Mage"),
    SUMMONER    (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Summoner"),
    NECROMANCER (new float[] {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,
                                 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
                new float[] {  0,  0,  0,  0,  0,  0,  0},
                "Necromancer");
    //</editor-fold>

    private String name;
    private float[] weaponList = new float[30];
    private float[] armorList = new float[7];

    private float shortSword;
    private float longSword;
    private float rapier;
    private float dagger;
    private float axe;
    private float bludgeon;
    private float polearm;
    private float greatSword;
    private float greatHammer;
    private float shortBow;
    private float longBow;
    private float crossBow;
    private float thrown;
    private float shortFA;
    private float longFA;
    private float greaterFA;
    private float staff;
    private float wand;
    private float grimoire;
    private float buckler;
    private float smallShield;
    private float largeShield;
    private float greatShield;
    private float whips;
    private float holySymbol;
    private float scythe;
    private float boomerang;
    private float claw;

    private float lightCloth;
    private float heavyCloth;
    private float hideLeather;
    private float studdedLeather;
    private float chainmail;
    private float scalemail;
    private float platemail;


    ClassType(float[] weaponList, float[] armorList, String name) {
        this.weaponList = weaponList;
        this.armorList = armorList;
        this.name = name;
    }

    ClassType(String name, float shortSword, float longSword, float rapier, float dagger, float axe, float bludgeon,
              float polearm, float greatSword, float greatHammer, float shortBow, float longBow, float crossBow,
              float thrown, float shortFA, float longFA, float greaterFA, float staff, float wand, float grimoire,
              float buckler, float smallShield, float largeShield, float greatShield, float whips, float holySymbol,
              float scythe, float boomerang, float claw, float lightCloth, float heavyCloth, float hideLeather,
              float studdedLeather, float chainmail, float scalemail, float platemail) {
        this.name = name;
        this.shortSword = shortSword;
        this.longSword = longSword;
        this.rapier = rapier;
        this.dagger = dagger;
        this.axe = axe;
        this.bludgeon = bludgeon;
        this.polearm = polearm;
        this.greatSword = greatSword;
        this.greatHammer = greatHammer;
        this.shortBow = shortBow;
        this.longBow = longBow;
        this.crossBow = crossBow;
        this.thrown = thrown;
        this.shortFA = shortFA;
        this.longFA = longFA;
        this.greaterFA = greaterFA;
        this.staff = staff;
        this.wand = wand;
        this.grimoire = grimoire;
        this.buckler = buckler;
        this.smallShield = smallShield;
        this.largeShield = largeShield;
        this.greatShield = greatShield;
        this.whips = whips;
        this.holySymbol = holySymbol;
        this.scythe = scythe;
        this.boomerang = boomerang;
        this.claw = claw;
        this.lightCloth = lightCloth;
        this.heavyCloth = heavyCloth;
        this.hideLeather = hideLeather;
        this.studdedLeather = studdedLeather;
        this.chainmail = chainmail;
        this.scalemail = scalemail;
        this.platemail = platemail;
    }


    //<editor-fold desc="Getters">
    public String getName() {
        return name;
    }

    public float[] getWeaponList() {
        return weaponList;
    }

    public float[] getArmorList() {
        return armorList;
    }

    public float getShortSword() {
        return shortSword;
    }

    public float getLongSword() {
        return longSword;
    }

    public float getRapier() {
        return rapier;
    }

    public float getDagger() {
        return dagger;
    }

    public float getAxe() {
        return axe;
    }

    public float getBludgeon() {
        return bludgeon;
    }

    public float getPolearm() {
        return polearm;
    }

    public float getGreatSword() {
        return greatSword;
    }

    public float getGreatHammer() {
        return greatHammer;
    }

    public float getShortBow() {
        return shortBow;
    }

    public float getLongBow() {
        return longBow;
    }

    public float getCrossBow() {
        return crossBow;
    }

    public float getThrown() {
        return thrown;
    }

    public float getShortFA() {
        return shortFA;
    }

    public float getLongFA() {
        return longFA;
    }

    public float getGreaterFA() {
        return greaterFA;
    }

    public float getStaff() {
        return staff;
    }

    public float getWand() {
        return wand;
    }

    public float getGrimoire() {
        return grimoire;
    }

    public float getBuckler() {
        return buckler;
    }

    public float getSmallShield() {
        return smallShield;
    }

    public float getLargeShield() {
        return largeShield;
    }

    public float getGreatShield() {
        return greatShield;
    }

    public float getWhips() {
        return whips;
    }

    public float getHolySymbol() {
        return holySymbol;
    }

    public float getScythe() {
        return scythe;
    }

    public float getBoomerang() {
        return boomerang;
    }

    public float getClaw() {
        return claw;
    }

    public float getLightCloth() {
        return lightCloth;
    }

    public float getHeavyCloth() {
        return heavyCloth;
    }

    public float getHideLeather() {
        return hideLeather;
    }

    public float getStuddedLeather() {
        return studdedLeather;
    }

    public float getChainmail() {
        return chainmail;
    }

    public float getScalemail() {
        return scalemail;
    }

    public float getPlatemail() {
        return platemail;
    }
    //</editor-fold>

}
