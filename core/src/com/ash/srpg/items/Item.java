package com.ash.srpg.items;

public class Item {

    protected int id;

    protected String name;
    protected String flavor;

    protected int stackSize = 0;
    protected int maxSize = 99;

    protected boolean sellable= false;
    protected int sellAmount;

    public Item(int id, String name, String flavor) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
    }

    public Item() {
    }

    // Sets the item as sellable
    public void setSellable(int sellAmount){
        sellable = true;
        this.sellAmount = sellAmount;
    }

    //makes the Item a key item; max stack size is 1 so it can't stack
    public void setKeyItem(){
        this.maxSize = 1;
    }

    //<editor-fold desc="Setters">
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getStackSize() {
        return stackSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isSellable() {
        return sellable;
    }

    public int getSellAmount() {
        return sellAmount;
    }
    //</editor-fold>
}