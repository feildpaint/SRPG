package com.ash.srpg.items;

public class Item {

    private int id;

    private String name;
    private String flavor;

    private int stackSize = 0;
    private int maxSize = 99;

    private boolean sellable= false;
    private int sellAmount;


    public Item(int id, String name, String flavor) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
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

}