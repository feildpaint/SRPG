package com.ash.srpg.items;

import com.ash.srpg.characters.ArmorType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemManger {

    private static final String ITEM_ARMOR_HEAD = "ItemArmorHeads";
    private static final String ITEM_ARMOR_CHEST = "ItemArmorChests";
    private static final String ITEM_ARMOR_LEG = "ItemArmorLegs";
    private static final String ITEM_ARMOR_HAND = "ItemArmorHands";
    private static final String ITEM_ARMOR_FEET = "ItemArmorFeet";

    public ArrayList<ItemArmorHead> headItems;
    public ArrayList<ItemArmorChest> chestItems;
    public ArrayList<ItemArmorChest> legItems;
    public ArrayList<ItemArmorChest> handItems;
    public ArrayList<ItemArmorChest> feetItems;


    public ItemManger(){
        headItems = new ArrayList<>();
        chestItems = new ArrayList<>();
        legItems = new ArrayList<>();
        handItems = new ArrayList<>();
        feetItems = new ArrayList<>();
    }

    public void loadItems(){
        loadItemArmorHead();
        loadItemArmorChest();
    }

    public static ItemArmorHead loadItemArmorHead(int id){
        FileHandle file = Gdx.files.internal("items/ItemArmorHeads.dat");

        ItemArmorHead item = new ItemArmorHead();

        boolean doNext = false;

        try {
            Scanner stream = new Scanner(new FileInputStream(file.file()));

            while (stream.hasNext()) {
                String next = stream.next();
                // variables
                // skips line

                if (next.contains("#")) stream.nextLine();

                    // gets ID
                else if (next.equals("id:")) {
                    int currentID = Integer.parseInt(stream.next());
                    if (id == currentID) {
                        item.setId(currentID);
                        doNext = true;
                    }
                }

                // gets name
                else if (next.equals("name:") && doNext) item.setName(stream.nextLine().trim()) ;

                    // gets flavor text
                else if (next.equals("lore:") && doNext) item.setFlavor(stream.nextLine()) ;

                    // gets type
                else if (next.equals("type:") && doNext)  {
                    int typeID = Integer.parseInt(stream.next()) ;
                    // switch to decide on the enum
                    switch (typeID){
                        case 0:
                            item.defineArmor(ArmorType.LIGHTCLOTH);
                            break;
                        case 1:
                            item.defineArmor(ArmorType.HEAVYCLOTH);
                            break;
                        case 2:
                            item.defineArmor(ArmorType.HIDELEATHER);
                            break;
                        case 3:
                            item.defineArmor(ArmorType.STUDDEDLEATHER);
                            break;
                        case 4:
                            item.defineArmor(ArmorType.CHAINMAIL);
                            break;
                        case 5:
                            item.defineArmor(ArmorType.SCALEMAIL);
                            break;
                        case 6:
                            item.defineArmor(ArmorType.PLATEMAIL);
                            break;
                        default:
                            item.defineArmor(ArmorType.OTHER);
                    }
                }

                // gets weight
                else if (next.equals("weight:") && doNext)    item.setWeight(Integer.parseInt(stream.next()));

                    // sub stats
                else if (next.equals("slash:") && doNext)     item.addSlashDef(Integer.parseInt(stream.next()));

                else if (next.equals("stab:") && doNext)      item.addStabDef(Integer.parseInt(stream.next()));

                else if (next.equals("blunt:") && doNext)     item.addBluntDef(Integer.parseInt(stream.next()));

                else if (next.equals("pierce:") && doNext)    item.addPierceDef(Integer.parseInt(stream.next()));

                else if (next.equals("bullet:") && doNext)    item.addBulletDef(Integer.parseInt(stream.next()));

                else if (next.equals("magic:") && doNext)     item.addMagicDef(Integer.parseInt(stream.next()));

                else if (next.equals("fire:") && doNext)      item.addFireDef(Integer.parseInt(stream.next()));

                else if (next.equals("ice:") && doNext)       item.addIceDef(Integer.parseInt(stream.next()));

                else if (next.equals("wind:") && doNext)      item.addWindDef(Integer.parseInt(stream.next()));

                else if (next.equals("earth:") && doNext)     item.addEarthDef(Integer.parseInt(stream.next()));

                else if (next.equals("lightning:") && doNext) item.addLightningDef(Integer.parseInt(stream.next()));

                else if (next.equals("divine:") && doNext)    item.addDivineDef(Integer.parseInt(stream.next()));

                else if (next.equals("dark:") && doNext)      item.addDarkDef(Integer.parseInt(stream.next()));

                else if (next.equals("poison:") && doNext)    item.addPoisonResist(Integer.parseInt(stream.next()));

                else if (next.equals("wound:") && doNext)     item.addWoundResist(Integer.parseInt(stream.next()));

                else if (next.equals("bleed:") && doNext)     item.addBleedResist(Integer.parseInt(stream.next()));

                else if (next.equals("confusion:") && doNext) item.addConfusionResist(Integer.parseInt(stream.next()));

                else if (next.equals("charm:") && doNext)     item.addCharmResist(Integer.parseInt(stream.next()));

                else if (next.equals("enfeeble:") && doNext)  item.addEnfeebleResist(Integer.parseInt(stream.next()));

                else if (next.equals("burn:") && doNext)      item.addBurnResist(Integer.parseInt(stream.next()));

                else if (next.equals("freeze:") && doNext)    item.addFreezeResist(Integer.parseInt(stream.next()));

                else if (next.equals("paralysis:") && doNext) item.addParalysisResist(Integer.parseInt(stream.next()));

                else if (next.equals("silence:") && doNext)   item.addSilenceResist(Integer.parseInt(stream.next()));

                else if (next.equals("blind:") && doNext)     item.addBlindResist(Integer.parseInt(stream.next()));

                else if (next.equals("doom:") && doNext)      item.addDoomResist(Integer.parseInt(stream.next()));


                    // adds new armor to the list
                else if (next.equals("end") && doNext) {
                    return item;
                }
            }

            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return loadItemArmorHead(0);

    }

    public static ItemArmorChest loadItemArmorChest(int id){
        FileHandle file = Gdx.files.internal("items/ItemArmorChests.dat");

        ItemArmorChest item = new ItemArmorChest();

        boolean doNext = false;

        try {
            Scanner stream = new Scanner(new FileInputStream(file.file()));

            while (stream.hasNext()) {
                String next = stream.next();
                // variables
                // skips line

                if (next.contains("#")) stream.nextLine();

                // gets ID
                else if (next.equals("id:")) {
                    int currentID = Integer.parseInt(stream.next());
                    if (id == currentID) {
                        item.setId(currentID);
                        doNext = true;
                    }
                }

                // gets name
                else if (next.equals("name:") && doNext) item.setName(stream.nextLine().trim()) ;

                    // gets flavor text
                else if (next.equals("lore:") && doNext) item.setFlavor(stream.nextLine()) ;

                    // gets type
                else if (next.equals("type:") && doNext)  {
                    int typeID = Integer.parseInt(stream.next()) ;
                    // switch to decide on the enum
                    switch (typeID){
                        case 0:
                            item.defineArmor(ArmorType.LIGHTCLOTH);
                            break;
                        case 1:
                            item.defineArmor(ArmorType.HEAVYCLOTH);
                            break;
                        case 2:
                            item.defineArmor(ArmorType.HIDELEATHER);
                            break;
                        case 3:
                            item.defineArmor(ArmorType.STUDDEDLEATHER);
                            break;
                        case 4:
                            item.defineArmor(ArmorType.CHAINMAIL);
                            break;
                        case 5:
                            item.defineArmor(ArmorType.SCALEMAIL);
                            break;
                        case 6:
                            item.defineArmor(ArmorType.PLATEMAIL);
                            break;
                        default:
                            item.defineArmor(ArmorType.OTHER);
                    }
                }

                // gets weight
                else if (next.equals("weight:") && doNext)    item.setWeight(Integer.parseInt(stream.next()));

                // sub stats
                else if (next.equals("slash:") && doNext)     item.addSlashDef(Integer.parseInt(stream.next()));

                else if (next.equals("stab:") && doNext)      item.addStabDef(Integer.parseInt(stream.next()));

                else if (next.equals("blunt:") && doNext)     item.addBluntDef(Integer.parseInt(stream.next()));

                else if (next.equals("pierce:") && doNext)    item.addPierceDef(Integer.parseInt(stream.next()));

                else if (next.equals("bullet:") && doNext)    item.addBulletDef(Integer.parseInt(stream.next()));

                else if (next.equals("magic:") && doNext)     item.addMagicDef(Integer.parseInt(stream.next()));

                else if (next.equals("fire:") && doNext)      item.addFireDef(Integer.parseInt(stream.next()));

                else if (next.equals("ice:") && doNext)       item.addIceDef(Integer.parseInt(stream.next()));

                else if (next.equals("wind:") && doNext)      item.addWindDef(Integer.parseInt(stream.next()));

                else if (next.equals("earth:") && doNext)     item.addEarthDef(Integer.parseInt(stream.next()));

                else if (next.equals("lightning:") && doNext) item.addLightningDef(Integer.parseInt(stream.next()));

                else if (next.equals("divine:") && doNext)    item.addDivineDef(Integer.parseInt(stream.next()));

                else if (next.equals("dark:") && doNext)      item.addDarkDef(Integer.parseInt(stream.next()));

                else if (next.equals("poison:") && doNext)    item.addPoisonResist(Integer.parseInt(stream.next()));

                else if (next.equals("wound:") && doNext)     item.addWoundResist(Integer.parseInt(stream.next()));

                else if (next.equals("bleed:") && doNext)     item.addBleedResist(Integer.parseInt(stream.next()));

                else if (next.equals("confusion:") && doNext) item.addConfusionResist(Integer.parseInt(stream.next()));

                else if (next.equals("charm:") && doNext)     item.addCharmResist(Integer.parseInt(stream.next()));

                else if (next.equals("enfeeble:") && doNext)  item.addEnfeebleResist(Integer.parseInt(stream.next()));

                else if (next.equals("burn:") && doNext)      item.addBurnResist(Integer.parseInt(stream.next()));

                else if (next.equals("freeze:") && doNext)    item.addFreezeResist(Integer.parseInt(stream.next()));

                else if (next.equals("paralysis:") && doNext) item.addParalysisResist(Integer.parseInt(stream.next()));

                else if (next.equals("silence:") && doNext)   item.addSilenceResist(Integer.parseInt(stream.next()));

                else if (next.equals("blind:") && doNext)     item.addBlindResist(Integer.parseInt(stream.next()));

                else if (next.equals("doom:") && doNext)      item.addDoomResist(Integer.parseInt(stream.next()));


                    // adds new armor to the list
                else if (next.equals("end") && doNext) {
                    return item;
                }
            }

            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return loadItemArmorChest(0);

    }

    //FIXME Put this method in the write game screen, new initializer screen

    @Deprecated
    private void loadItemArmorHead() {
        FileHandle file = Gdx.files.internal("items/ItemArmorHeads.dat");

        ItemArmorHead item = new ItemArmorHead();

        try {
            Scanner stream = new Scanner(new FileInputStream(file.file()));

            while (stream.hasNext()) {
                String next = stream.next();
                // variables
                // skips line

                if (next.contains("#")) stream.nextLine();

                // gets ID
                else if (next.equals("id:")) item.setId(Integer.parseInt(stream.next()));

                // gets name
                else if (next.equals("name:")) item.setName(stream.nextLine().trim()) ;

                // gets flavor text
                else if (next.equals("lore:")) item.setFlavor(stream.nextLine()) ;

                // gets type
                else if (next.equals("type:"))  {
                    int typeID = Integer.parseInt(stream.next()) ;
                    // switch to decide on the enum
                    switch (typeID){
                        case 0:
                            item.defineArmor(ArmorType.LIGHTCLOTH);
                            break;
                        case 1:
                            item.defineArmor(ArmorType.HEAVYCLOTH);
                            break;
                        case 2:
                            item.defineArmor(ArmorType.HIDELEATHER);
                            break;
                        case 3:
                            item.defineArmor(ArmorType.STUDDEDLEATHER);
                            break;
                        case 4:
                            item.defineArmor(ArmorType.CHAINMAIL);
                            break;
                        case 5:
                            item.defineArmor(ArmorType.SCALEMAIL);
                            break;
                        case 6:
                            item.defineArmor(ArmorType.PLATEMAIL);
                            break;
                        default:
                            item.defineArmor(ArmorType.OTHER);
                    }
                }

                // gets weight
                else if (next.equals("weight:"))    item.setWeight(Integer.parseInt(stream.next()));

                // sub stats
                else if (next.equals("slash:"))     item.addSlashDef(Integer.parseInt(stream.next()));

                else if (next.equals("stab:"))      item.addStabDef(Integer.parseInt(stream.next()));

                else if (next.equals("blunt:"))     item.addBluntDef(Integer.parseInt(stream.next()));

                else if (next.equals("pierce:"))    item.addPierceDef(Integer.parseInt(stream.next()));

                else if (next.equals("bullet:"))    item.addBulletDef(Integer.parseInt(stream.next()));

                else if (next.equals("magic:"))     item.addMagicDef(Integer.parseInt(stream.next()));

                else if (next.equals("fire:"))      item.addFireDef(Integer.parseInt(stream.next()));

                else if (next.equals("ice:"))       item.addIceDef(Integer.parseInt(stream.next()));

                else if (next.equals("wind:"))      item.addWindDef(Integer.parseInt(stream.next()));

                else if (next.equals("earth:"))     item.addEarthDef(Integer.parseInt(stream.next()));

                else if (next.equals("lightning:")) item.addLightningDef(Integer.parseInt(stream.next()));

                else if (next.equals("divine:"))    item.addDivineDef(Integer.parseInt(stream.next()));

                else if (next.equals("dark:"))      item.addDarkDef(Integer.parseInt(stream.next()));

                else if (next.equals("poison:"))    item.addPoisonResist(Integer.parseInt(stream.next()));

                else if (next.equals("wound:"))     item.addWoundResist(Integer.parseInt(stream.next()));

                else if (next.equals("bleed:"))     item.addBleedResist(Integer.parseInt(stream.next()));

                else if (next.equals("confusion:")) item.addConfusionResist(Integer.parseInt(stream.next()));

                else if (next.equals("charm:"))     item.addCharmResist(Integer.parseInt(stream.next()));

                else if (next.equals("enfeeble:"))  item.addEnfeebleResist(Integer.parseInt(stream.next()));

                else if (next.equals("burn:"))      item.addBurnResist(Integer.parseInt(stream.next()));

                else if (next.equals("freeze:"))    item.addFreezeResist(Integer.parseInt(stream.next()));

                else if (next.equals("paralysis:")) item.addParalysisResist(Integer.parseInt(stream.next()));

                else if (next.equals("silence:"))   item.addSilenceResist(Integer.parseInt(stream.next()));

                else if (next.equals("blind:"))     item.addBlindResist(Integer.parseInt(stream.next()));

                else if (next.equals("doom:"))      item.addDoomResist(Integer.parseInt(stream.next()));


                // adds new armor to the list
                else if (next.equals("end")) {
                    headItems.add(item);
                    item = new ItemArmorHead();
                }
            }

            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Deprecated
    private void loadItemArmorChest() {
        FileHandle file = Gdx.files.internal("items/ItemArmorChests.dat");

        ItemArmorChest item = new ItemArmorChest();

        try {
            Scanner stream = new Scanner(new FileInputStream(file.file()));

            while (stream.hasNext()) {
                String next = stream.next();
                // variables
                // skips line
                if (next.contains("#")) stream.nextLine();

                // gets ID
                else if (next.equals("id:")) item.setId(Integer.parseInt(stream.next()));

                    // gets name
                else if (next.equals("name:")) item.setName(stream.nextLine().trim()) ;

                    // gets flavor text
                else if (next.equals("lore:")) item.setFlavor(stream.nextLine()) ;

                    // gets type
                else if (next.equals("type:"))  {
                    int typeID = Integer.parseInt(stream.next()) ;
                    // switch to decide on the enum
                    switch (typeID){
                        case 0:
                            item.defineArmor(ArmorType.LIGHTCLOTH);
                            break;
                        case 1:
                            item.defineArmor(ArmorType.HEAVYCLOTH);
                            break;
                        case 2:
                            item.defineArmor(ArmorType.HIDELEATHER);
                            break;
                        case 3:
                            item.defineArmor(ArmorType.STUDDEDLEATHER);
                            break;
                        case 4:
                            item.defineArmor(ArmorType.CHAINMAIL);
                            break;
                        case 5:
                            item.defineArmor(ArmorType.SCALEMAIL);
                            break;
                        case 6:
                            item.defineArmor(ArmorType.PLATEMAIL);
                            break;
                        default:
                            item.defineArmor(ArmorType.OTHER);
                    }
                }

                // gets weight
                else if (next.equals("weight:")) item.setWeight(Integer.parseInt(stream.next()));


                else if (next.equals("slash:")) item.addSlashDef(Integer.parseInt(stream.next()));

                else if (next.equals("stab:")) item.addStabDef(Integer.parseInt(stream.next()));

                else if (next.equals("blunt:")) item.addBluntDef(Integer.parseInt(stream.next()));

                else if (next.equals("pierce:")) item.addPierceDef(Integer.parseInt(stream.next()));

                else if (next.equals("bullet:")) item.addBulletDef(Integer.parseInt(stream.next()));

                else if (next.equals("magic:")) item.addMagicDef(Integer.parseInt(stream.next()));

                else if (next.equals("fire:")) item.addFireDef(Integer.parseInt(stream.next()));

                else if (next.equals("ice:")) item.addIceDef(Integer.parseInt(stream.next()));

                else if (next.equals("wind:")) item.addWindDef(Integer.parseInt(stream.next()));

                else if (next.equals("earth:")) item.addEarthDef(Integer.parseInt(stream.next()));

                else if (next.equals("lightning:")) item.addLightningDef(Integer.parseInt(stream.next()));

                else if (next.equals("divine:")) item.addDivineDef(Integer.parseInt(stream.next()));

                else if (next.equals("dark:")) item.addDarkDef(Integer.parseInt(stream.next()));

                else if (next.equals("poison:")) item.addPoisonResist(Integer.parseInt(stream.next()));

                else if (next.equals("wound:")) item.addWoundResist(Integer.parseInt(stream.next()));

                else if (next.equals("bleed:")) item.addBleedResist(Integer.parseInt(stream.next()));

                else if (next.equals("confusion:")) item.addConfusionResist(Integer.parseInt(stream.next()));

                else if (next.equals("charm:")) item.addCharmResist(Integer.parseInt(stream.next()));

                else if (next.equals("enfeeble:")) item.addEnfeebleResist(Integer.parseInt(stream.next()));

                else if (next.equals("burn:")) item.addBurnResist(Integer.parseInt(stream.next()));

                else if (next.equals("freeze:")) item.addFreezeResist(Integer.parseInt(stream.next()));

                else if (next.equals("paralysis:")) item.addParalysisResist(Integer.parseInt(stream.next()));

                else if (next.equals("silence:")) item.addSilenceResist(Integer.parseInt(stream.next()));

                else if (next.equals("blind:")) item.addBlindResist(Integer.parseInt(stream.next()));

                else if (next.equals("doom:")) item.addDoomResist(Integer.parseInt(stream.next()));


                    // adds new armor to the list
                else if (next.equals("end")) {
                    chestItems.add(item);
                    item = new ItemArmorChest();
                }
            }

            stream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString(){
        String str = "";
        for (ItemArmorHead i : headItems){
            str += i.toString();
        }
        for (ItemArmorChest i : chestItems){
            str += i.toString();
        }
        return str;
    }

}
