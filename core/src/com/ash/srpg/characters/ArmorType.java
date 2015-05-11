package com.ash.srpg.characters;

@SuppressWarnings("SpellCheckingInspection")
public enum ArmorType {

    //<editor-fold desc="Types">
    /*00*/ LIGHTCLOTH      ("Light Cloth",    50,  6,  2,  4,  4,  2, 40),
    /*01*/ HEAVYCLOTH      ("Heavy Cloth",    30, 10,  6,  6,  6,  4, 30),
    /*02*/ HIDELEATHER     ("Hide Leather",   45, 12, 10, 10, 10, 14, 12),
    /*03*/ STUDDEDLEATHER  ("Studded Leather",40, 14, 12, 14, 14, 16,  8),
    /*04*/ CHAINMAIL       ("Chainmail",      28, 14, 16,  8,  8, 16, -4),
    /*05*/ SCALEMAIL       ("Scalemail",      22, 18, 18, 12, 12, 18,-12),
    /*06*/ PLATEMAIL       ("Platemail",      10, 24, 20, 10, 10, 20,-20),
    /*07*/ OTHER           ("Other",           0,  0,  0,  0,  0,  0,  0);
    //</editor-fold>

    private String name;

    private int speed;

    private int slashDef;
    private int stabDef;
    private int bluntDef;
    private int pierceDef;
    private int bulletDef;
    private int magicDef;

    ArmorType(String name, int speed, int slashDef, int stabDef, int bluntDef, int pierceDef, int bulletDef, int magicDef) {
        this.name = name;
        this.speed = speed;
        this.slashDef = slashDef;
        this.stabDef = stabDef;
        this.bluntDef = bluntDef;
        this.pierceDef = pierceDef;
        this.bulletDef = bulletDef;
        this.magicDef = magicDef;
    }

    //<editor-fold desc="Getters">
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
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
    //</editor-fold>

}
