package com.ash.srpg.characters;


@SuppressWarnings("SpellCheckingInspection")
public class Unit {

    // stats
    protected int vitality = 0;
    protected int agility = 0;
    protected int strength = 0;
    protected int finesse = 0;
    protected int willpower = 0;
    protected int intellect = 0;
    protected int luck = 0;

    // substats
    protected int healthPoints;
    protected int manaPoints;
    protected int actionPoints;
    protected int totalWeight;
    protected int moveDistance;
    protected int speed;
    protected int weapoonSpeed;
    protected double accuracy;
    protected double evade;
    protected int discovery;

    // Slash Stab Blunt Pierce Bullet
    protected int[] physDef = new int[5];
    protected int[] pysAtk = new int[5];

    // Magic Fire Ice Wind Earth Lightning Divine Dark
    protected int[] magicDef = new int[8];
    protected int[] magicAtk = new int[8];

    // Poison Wound Bleed Confusion Charm Enfeeble
    protected int[] statusResist = new int[6];

    // Burn Freeze Paralysis Silence Blind Doom
    protected int[] magicResis = new int[6];



    public Unit() {
        //<editor-fold desc="Test stuff">
        //        int[] stats = race.getStats();
//
//        vitality += stats[0];
//        agility += stats[1];
//        strength += stats[2];
//        finesse += stats[3];
//        willpower += stats[4];
//        intellect += stats[5];
//        luck += stats[6];

//        FileHandle file = Gdx.files.internal("data/test.dat");
//
//        try {
//            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file.file()));
//
//            vitality += Integer.parseInt(stream.readUTF());
//            agility += Integer.parseInt(stream.readUTF());
//            strength += Integer.parseInt(stream.readUTF());
//            finesse += Integer.parseInt(stream.readUTF());
//            willpower += Integer.parseInt(stream.readUTF());
//            intellect += Integer.parseInt(stream.readUTF());
//            luck += Integer.parseInt(stream.readUTF());
//
//            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //</editor-fold>

        vitality = 5;
        agility = 5;
        strength = 5;
        finesse = 5;
        willpower = 5;
        intellect = 5;
        luck = 5;

        calculateSubstats();

    }

    public void calculateSubstats(){
        checkStats();

        calculateHP();
        calculateMP();

        calculateAcc();
        calculateEvade();

        checkStats();
    }

    protected void calculateHP(){
        healthPoints = vitality * (20 + (int)(Math.pow(vitality, 0.8)));
        healthPoints += strength * (4 + (int)Math.pow(strength, 0.6));
        healthPoints += willpower * ((int)Math.pow(willpower, 0.4));

        if (vitality == 99 && strength == 99 && willpower == 99)
            healthPoints = 9999;
    }

    protected void calculateMP(){
        manaPoints = intellect * (4 + (int)(Math.pow(intellect, 0.8)));
        manaPoints += willpower * ((int)(Math.pow(willpower, 0.4)));

        if (intellect == 99 && willpower == 99)
            manaPoints = 5000;
    }

    protected void calculateAcc(){
        accuracy = 50;
        accuracy += Math.sqrt((double) finesse) * 5.0;
        accuracy += Math.sqrt((double) luck);
        accuracy = Math.round(accuracy * 100.0) / 100.0;
    }

    protected void calculateEvade(){
        evade = 6.0 * Math.sqrt((double) agility);
        evade += (Math.pow((double) agility, 0.6)) * 2.5;
        evade += Math.sqrt((double) luck);
        evade = Math.round(evade * 100.0) / 100.0;
    }

    protected void checkStats(){
        if (vitality > 99) vitality = 99;
        else if (vitality < 0) vitality = 0;

        if (agility > 99) agility = 99;
        else if (agility < 0) agility = 0;

        if (strength > 99) strength = 99;
        else if (strength < 0) strength = 0;

        if (finesse > 99) finesse = 99;
        else if (finesse < 0) finesse = 0;

        if (willpower > 99) willpower = 99;
        else if (willpower < 0) willpower = 0;

        if (intellect > 99) intellect = 99;
        else if (intellect < 0) intellect = 0;

        if (luck > 99) vitality = 99;
        else if (luck < 0) vitality = 0;


        if (healthPoints < 1) healthPoints = 1;
        else if (healthPoints > 9999) healthPoints = 9999;

        if (manaPoints < 1) manaPoints = 1;
        else if (manaPoints > 5000) manaPoints = 5000;

        if (accuracy < 0) accuracy = 0;
        else if (accuracy > 100) accuracy = 100;

        if (evade < 0) evade = 0;
        else if (evade > 100) evade = 100;
    }

    public String toString() {
        String str;
        str  = "Vitality: " + vitality + " ";
        str  += "Agility: " + agility + " ";
        str  += "Strength: " + strength + " ";
        str  += "Finesse: " + finesse + " ";
        str  += "Willpower: " + willpower + " ";
        str  += "Intellect: " + intellect + " ";
        str  += "Luck: " + luck + "\n";
        str += "Substats:\n";
        str += "HP: " + healthPoints + " ";
        str += "MP: " + manaPoints + " ";
        str += "AP: " + actionPoints + " ";
        str += "Weight: " + totalWeight + " ";
        str += "Move Distance: " + moveDistance + " ";
        str += "Speed: " + speed + " ";
        str += "Weapon Speed: " + weapoonSpeed + " ";
        str += "Accuracy: " + accuracy + " ";
        str += "Evade: " + evade + " ";
        str += "Discovery: " + discovery + " ";

        str += "\n";

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
