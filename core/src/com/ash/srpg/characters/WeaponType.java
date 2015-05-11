package com.ash.srpg.characters;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum WeaponType {

    //<editor-fold desc="Types">
    // melee
    /*00*/ SHORTSWORD  ("Shortsword",     12, 20, 12,  5,  0,  0,  0,  4),
    /*01*/ LONGSWORD   ("Longsword",       5, 25, 18,  8,  0,  0,  0,  6),
    /*02*/ RAPIER      ("Rapier",         15,  2, 20,  0, 10,  0,  0,  0),
    /*03*/ DAGGER      ("Dagger",         20, 10, 10,  3,  0,  0,  0,  2),
    /*04*/ AXE         ("Axe",            10, 18, 12,  8,  0,  0,  0,  3),
    /*05*/ BLUDGEON    ("Bludgeon",       10,  0,  0, 20,  0,  0,  0,  4),
    /*06*/ POLEARM     ("Polarm",          8, 12, 12,  8,  5,  0,  0,  8),
    /*07*/ GREATSWORD  ("Greatsword",      5, 32, 10, 10,  0,  0,  0,  8),
    /*08*/ GREATHAMMER ("Greathammer",     3,  0,  0, 50,  0,  0,  0, 10),

    // ran ged
    /*09*/ SHORTBOW    ("Shortbow",       15,  0,  0,  0, 20,  0,  0,  2),
    /*10*/ LONGBOW     ("Longbow",         8,  0,  0,  0, 28,  0,  0,  2),
    /*11*/ CROSSBOW    ("Crossbow",       10,  0,  0,  0, 24,  0,  0,  2),

    // gun s
    /*12*/ SHORTFIREARM("Short Firearm",  16,  0,  0,  4,  0, 16,  0,      2),
    /*13*/ LONGFIREARM ("Long Firearm",   12,  0,  0,  8,  0, 25,  0,  3),
    /*14*/ GREATFIREARM("Greater Firearm", 6,  0,  0, 12,  0, 32,  0,  4),

    // mag ic tools
    /*15*/ STAFF       ("Staff",          10,  0,  0, 10,  0,  0, 26,  6),
    /*16*/ WANT        ("Wand",           16,  0,  0,  0,  0,  0, 22,  2),
    /*17*/ GRIMOIRE    ("Grimoire",       14,  0,  0,  0,  0,  0, 18,  4),

    // she ilds
    /*18*/ BUCKLER     ("Buckler",        20,  0,  0,  2,  0,  0,  0, 12),
    /*19*/ SMALLSHIELD ("Small Shield",   14,  0,  0,  8,  0,  0,  0, 18),
    /*20*/ LARGESHIELD ("Large Shield",   10,  0,  0, 10,  0,  0,  0, 24),
    /*21*/ GREATSHEILD ("Greatshield",     6,  0,  0, 14,  0,  0,  0, 32),

    // spe cial types
    /*22*/ WHIP        ("Whip",           18, 10,  0,  0,  0,  0,  0,  3),
    /*23*/ HOLYSYMBOL  ("Holy Symbol",    12,  0,  0, 12,  0,  0, 10,  8),
    /*24*/ SCYTHE      ("Scythe",         12, 20,  8,  0,  6,  0,  0,  6),
    /*25*/ BOOMERANG   ("Boomerang",      14, 14,  0,  4,  0,  0,  0,  2),
    /*26*/ CLAW        ("Claw",           18, 15, 12,  0, 10,  0,  0,  2),

    /*27*/OTHER       ("Other",           0,  0,  0,  0,  0,  0,  0,  0);
    //</editor-fold>

    private int slashDmg;
    private int stabDmg;
    private int bluntDmg;
    private int pierceDmg;
    private int bulletDmg;
    private int magicDmg;

    private int speed;
    private int baseDef;

    private String name;

    WeaponType(String name, int speed, int slashDmg, int stabDmg, int bluntDmg, int pierceDmg, int bulletDmg, int magicDmg, int baseDef) {

        this.name = name;
        this.speed = speed;
        this.slashDmg = slashDmg;
        this.stabDmg = stabDmg;
        this.bluntDmg = bluntDmg;
        this.pierceDmg = pierceDmg;
        this.bulletDmg = bulletDmg;
        this.magicDmg = magicDmg;
        this.baseDef = baseDef;
    }

    //<editor-fold desc="Getters">
    public String getname() {
        return name;
    }

    public int getSlashDmg() {
        return slashDmg;
    }

    public int getStabDmg() {
        return stabDmg;
    }

    public int getBluntDmg() {
        return bluntDmg;
    }

    public int getPierceDmg() {
        return pierceDmg;
    }

    public int getBulletDmg() {
        return bulletDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBaseDef() {
        return baseDef;
    }

    //</editor-fold>
}
